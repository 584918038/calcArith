package com.calc.review.p5;

import java.util.concurrent.TimeUnit;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/8/10
 */
public class ThreadStatusDemo {


    public static void main(String[] args) {

        // time waiting
        new Thread(()-> {

            while (true) {

                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Time_Waiting_Demo").start();

        // waiting
        new Thread(()->{

            while (true) {
                synchronized (ThreadStatusDemo.class) {

                    try {
                        ThreadStatusDemo.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        },"Waiting").start();

        new Thread(new BlockedDemo(),"Blocked-Demo-01").start();
        new Thread(new BlockedDemo(),"Blocked-Demo-02").start();
    }

    static class BlockedDemo extends Thread {

        public void run() {

            synchronized (BlockedDemo.class) {

                while (true) { // 死循环

                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
