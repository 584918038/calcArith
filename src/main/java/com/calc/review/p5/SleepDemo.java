package com.calc.review.p5;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/8/11
 */
public class SleepDemo extends Thread{

    @Override
    public void run() {

        System.out.println("begin :" + System.currentTimeMillis());
        try {
            Thread.sleep(3000);
            System.out.println("end :" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        new SleepDemo().start();

    }
}
