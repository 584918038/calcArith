package com.calc.review.p5;

import java.util.concurrent.TimeUnit;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/8/15
 */
public class StopDemo {

    static volatile boolean stop = false;

    public static void main(String[] args) {

        Thread t1 = new Thread(new StopThread());

        t1.start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stop = true;
    }

    static class StopThread implements Runnable {

        @Override
        public void run() {

            while (!stop) {

                System.out.println("持续运行");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
