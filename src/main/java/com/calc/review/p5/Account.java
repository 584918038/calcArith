package com.calc.review.p5;

import lombok.Data;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/10/21
 */
@Data
public class Account {

    private String accountName;

    // 余额
    private int balance;

    public Account(String accountName, int balance) {
        this.accountName = accountName;
        this.balance = balance;
    }

    public Account() {
    }

    // 转出
    public void debit(int amount) {

        this.balance = this.balance - amount;
    }

    // 转入
    public void creDebit(int amount) {

        this.balance = this.balance + amount;
    }

}
