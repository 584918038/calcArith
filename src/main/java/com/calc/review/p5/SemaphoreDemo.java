package com.calc.review.p5;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/9/25
 */
public class SemaphoreDemo {

    public static void main(String[] args) throws Exception{

        // 当前可以获得的最大许可数量是5个
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 10; i ++) {
            new Car(i,semaphore).start();
            TimeUnit.SECONDS.sleep(1);
        }
    }

    static class Car extends Thread {

        private int num;

        private Semaphore semaphore;

        public Car(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }


        public void run() {
            try {
                semaphore.acquire(); // 获得一个许可
                System.out.println("第"+num+"占用一个停车位");
                TimeUnit.SECONDS.sleep(2);
                semaphore.release();
                System.out.println("第"+num+"车走了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


