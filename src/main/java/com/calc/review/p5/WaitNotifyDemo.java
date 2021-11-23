package com.calc.review.p5;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/8/15
 */
public class WaitNotifyDemo {

    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<>();

        int size = 10;

        Producer producer = new Producer(queue,size);
        Consumer consumer = new Consumer(queue,size);

        Thread t1 = new Thread(producer);
        Thread t2  = new Thread(consumer);

        t1.start();
        t2.start();

    }
}
