package com.calc.review.p5;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/8/16
 */
public class VisibleDemo {

    public volatile static boolean stop = false;


    public static void main(String[] args) {

        Thread thread = new Thread(() ->{

            int i = 0;

            while (!stop) {
                i ++;
            }

            System.out.println("result :" + i);
        });

        thread.start();

        System.out.println("begin start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        stop = true;
    }

}
