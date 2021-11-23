package com.calc.review.p5;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/10/21
 */
public class TestMain {

    public static void main(String[] args) {

        Account fromAccount = new Account("张三",100000);
        Account toAccount = new Account("李四",200000);

//        Thread a = new Thread(new TransferAccount(fromAccount,toAccount,1));
//        Thread b = new Thread(new TransferAccount(toAccount,fromAccount,2));

//        Allocator allocator = new Allocator();
//
//        Thread a = new Thread(new TransferAccount01(fromAccount,toAccount,1,allocator));
//        Thread b = new Thread(new TransferAccount01(toAccount,fromAccount,2,allocator));


//        Thread a = new Thread(new TransferAccount02(fromAccount,toAccount,1));
//        Thread b = new Thread(new TransferAccount02(toAccount,fromAccount,2));

        Thread a = new Thread(new TransferAccount03(fromAccount,toAccount,1));
        Thread b = new Thread(new TransferAccount03(toAccount,fromAccount,2));

        a.start();
        b.start();
    }
}
