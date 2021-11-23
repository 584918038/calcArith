package com.calc.review.p5;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/8/10
 */
public class ThreadJoinDemo {

    private static int x = 0;
    private static int i = 0;


    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {

            i = 1;
            x = 2;
        });

        Thread t2 = new Thread(() -> {

            i = x + 2;
        });

        t1.start();
        t1.join(); // t1线程的执行结果对t2可见(t1线程一定比t2线程先执行)
        t2.start();

        Thread.sleep(1000);

        System.out.println("result： " + i);

    }
}
