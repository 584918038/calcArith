package com.calc.review.p5;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/10/21
 */
public class TransferAccount03 implements Runnable {

    private Account fromAccount;

    private Account toAccount;

    private int amount;

    Allocator allocator;

    public TransferAccount03(Account fromAccount, Account toAccount, int amount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.allocator = allocator;
    }


    @Override
    public void run() {

        Account left = null;
        Account right = null;

        if (fromAccount.hashCode() > toAccount.hashCode()) {
            left = toAccount;
            right = fromAccount;
        }

        while (true) {
            // 统一获取临界资源

            synchronized (left) {
                synchronized (right) {
                    if (fromAccount.getBalance() >= amount) {
                        fromAccount.debit(amount);
                        toAccount.creDebit(amount);
                    }
                }
                System.out.println(fromAccount.getAccountName() + "---" + fromAccount.getBalance());
                System.out.println(toAccount.getAccountName() + "---" + toAccount.getBalance());
            }

        }
    }
}