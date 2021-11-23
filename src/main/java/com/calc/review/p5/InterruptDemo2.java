package com.calc.review.p5;

import java.util.concurrent.TimeUnit;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/8/15
 */
public class InterruptDemo2 {

    private static int i ;

    public static void main(String[] args) {

        Thread thread = new Thread(() ->{

            while (true) { // 判断中断标志

                // 标识标识被中断过
                if (Thread.currentThread().isInterrupted()) {

                    System.out.println("before: " + Thread.currentThread().isInterrupted());
                    Thread.interrupted(); // 对中断标识复位 false
                    System.out.println("after: " + Thread.currentThread().isInterrupted());
                }
            }
        });

        thread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // interrupt 这个属性由false ---> true
        thread.interrupt();// 中断(友好)
    }
}
