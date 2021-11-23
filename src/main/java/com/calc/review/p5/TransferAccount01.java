package com.calc.review.p5;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/10/21
 */
public class TransferAccount01 implements Runnable {

    private Account fromAccount;

    private Account toAccount;

    private int amount;

    Allocator allocator;

    public TransferAccount01(Account fromAccount, Account toAccount, int amount, Allocator allocator) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.allocator = allocator;
    }


    @Override
    public void run() {

        while (true) {
            // 统一获取临界资源
            if (allocator.apply(fromAccount, toAccount)) {
                try {
                    synchronized (fromAccount) {
                        synchronized (toAccount) {
                            if (fromAccount.getBalance() >= amount) {
                                fromAccount.debit(amount);
                                toAccount.creDebit(amount);
                            }
                        }
                        System.out.println(fromAccount.getAccountName() + "---" + fromAccount.getBalance());
                        System.out.println(toAccount.getAccountName() + "---" + toAccount.getBalance());
                    }
                } finally {
                    allocator.free(fromAccount, toAccount);
                }
            }
        }
    }
}