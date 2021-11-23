package com.calc.review.p5;

import java.util.Queue;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/8/15
 */
public class Consumer implements Runnable{

    private Queue<String> bags;

    private int size;

    public Consumer(Queue<String> bags, int size) {
        this.bags = bags;
        this.size = size;
    }

    @Override
    public void run() {

         while (true) {

             synchronized (bags) {

                 while (bags.isEmpty()) {

                     System.out.println("bags为空");
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

                 String removeBag = bags.remove();
                 System.out.println("消费者消费: " + removeBag);
                 bags.notifyAll();
             }
         }
    }
}
