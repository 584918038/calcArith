package com.calc.review.leet3code;

import java.util.concurrent.Semaphore;

/**
 * @since 2021/7/2
 */
public class Question2 {

    // 2 两个线程交替打印1-100的整数，一个打印奇数，一个打印偶数，要求输出结果有序。


    private volatile int times;
    private volatile int count = 1;
    private Semaphore semaphoreA = new Semaphore(1);
    private Semaphore semaphoreB = new Semaphore(0);


    private void print(int value, Semaphore current, Semaphore next) throws InterruptedException {

        for (int i = 1; i < 101; i++) {

            current.acquire();
            System.out.println(value);
            next.release();
            count ++;
        }
    }

    public void printA() {

        try {
            print(count, semaphoreA, semaphoreB);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printB() {

        try {
            print(count, semaphoreB, semaphoreA);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Question2 question2 = new Question2(100);


        new Thread(question2::printA).start();
        new Thread(question2::printB).start();
    }

    public Question2(int times) {
        this.times = times;
    }
}
