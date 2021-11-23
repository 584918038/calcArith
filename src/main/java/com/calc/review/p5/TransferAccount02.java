package com.calc.review.p5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/10/21
 */
public class TransferAccount02 implements Runnable {

    private Account fromAccount;

    private Account toAccount;

    private int amount;

    Lock fromLock = new ReentrantLock();
    Lock toLock = new ReentrantLock();


    public TransferAccount02(Account fromAccount, Account toAccount, int amount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }


    @Override
    public void run() {

        while (true) {
            if (fromLock.tryLock()) {
                if (toLock.tryLock()) {
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