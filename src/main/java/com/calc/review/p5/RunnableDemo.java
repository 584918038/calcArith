package com.calc.review.p5;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/8/10
 */
public class RunnableDemo implements Runnable{

    @Override
    public void run() {

        System.out.println("当前线程: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {

        RunnableDemo runnableDemo = new RunnableDemo();

        Thread thread = new Thread(runnableDemo);

        thread.start();
    }
}
