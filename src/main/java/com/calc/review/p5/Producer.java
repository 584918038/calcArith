package com.calc.review.p5;

import java.util.Queue;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/8/15
 */
public class Producer implements Runnable {

    private Queue<String> bags;

    private int size;

    public Producer(Queue<String> bags, int size) {
        this.bags = bags;
        this.size = size;
    }


    @Override
    public void run() {

        int i = 0;

        while (true) {

            i++;
            synchronized (bags) {

                while (bags.size() == size) {

                    System.out.println("bags已经满了");
                    // todo? 阻塞
                    try {
                        bags.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("生产者-生产: bag" + i);
                bags.add("bag" + i);
                // 唤醒
                bags.notify();
            }
        }
    }
}
