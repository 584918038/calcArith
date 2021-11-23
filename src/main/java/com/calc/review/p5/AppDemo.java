package com.calc.review.p5;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/9/23
 */
public class AppDemo implements Runnable{

    static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) {

        for (int i = 9; i < 1000; i ++) {
            new Thread(new AppDemo()).start();
        }

        countDownLatch.countDown();
    }

    @Override
    public void run() {
        try {
            System.out.println("执行完毕");
            countDownLatch.await(); // 阻塞
            // TODO: 2021/9/23
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
