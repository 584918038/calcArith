package com.calc.review.p5;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/8/15
 */
public class InterruptDemo {

    private static int i ;

    public static void main(String[] args) {

        Thread thread = new Thread(() ->{

            while (!Thread.currentThread().isInterrupted()) { // 判断中断标志
                i ++;
            }
        });

        thread.start();
        // interrupt 这个属性由false ---> true
        thread.interrupt();// 中断(友好)
    }
}
