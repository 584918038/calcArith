package com.calc.review.p5;

/**
 * @author xxx xshlxx@126.com
 * @since 2021/8/16
 */
public class AtomicDemo {

    private static  int count = 0;


    public static void incr() {

//        try {
//            Thread.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();其实
//        }
        count ++;
    }

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 1800; i ++) {

            new Thread(AtomicDemo::incr).start();
        }

        System.out.println("count: " + count);
    }
}
