package com.calc.review.p5;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/10/21
 */
public class TransferAccount implements Runnable{

    private Account fromAccount;

    private Account toAccount;

    private int amount;

    public TransferAccount(Account fromAccount, Account toAccount, int amount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }


    @Override
    public void run() {

        while (true) {

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
        }
    }
}
