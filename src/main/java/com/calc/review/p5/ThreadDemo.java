package com.calc.review.p5;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/8/10
 */
public class ThreadDemo extends Thread{

    @Override
    public void run() {
        System.out.println("当前线程: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {

        ThreadDemo threadDemo = new ThreadDemo();

        threadDemo.start();// 启动一个线程
    }
}
