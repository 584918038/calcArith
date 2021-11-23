package com.calc.review.p5;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/9/9
 */
public class ThreadLocalDemo {

    private static Integer num = 0;

    public static  ThreadLocal<Integer> local = new ThreadLocal<Integer>() {

        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {

        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {

            threads[i] = new Thread(() -> {
                int num = local.get(); // 拿到初始值
                num += 5;
                local.set(num);
                System.out.println(Thread.currentThread().getName() + "---> " + num);
            }, "Thread-" + i);
        }

        for (Thread thread : threads) {
            thread.start();
        }
    }
}
