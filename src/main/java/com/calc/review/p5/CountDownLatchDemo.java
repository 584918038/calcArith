package com.calc.review.p5;

import java.util.concurrent.CountDownLatch;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/9/23
 */
public class CountDownLatchDemo {


    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(3);

        // 倒计时
        new Thread(countDownLatch::countDown).start();
        new Thread(countDownLatch::countDown).start();
        new Thread(countDownLatch::countDown).start();

        countDownLatch.await(); // 阻塞主线程
        System.out.println("线程执行完毕");

    }
}
