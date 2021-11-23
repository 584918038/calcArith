package com.calc.review.test;

import lombok.extern.slf4j.Slf4j;

/**
 * wait方法：wait是要释放对象锁，进入等待池。既然是释放对象锁，那么肯定是先要获得锁。
 * 所以wait必须要写在synchronized代码块中，否则会报异常。
 * notify方法：也需要写在synchronized代码块中，调用对象的这两个方法也需要先获得该对象的锁。
 * notify，notifyAll，唤醒等待该对象同步锁的线程，并放入该对象的锁池中。对象的锁池中线程可以去竞争得到对象锁，然后开始执行。
 */
@Slf4j
public class WaitAndNotify {
    private static final Object LOCK = new Object();

    public static void main(String[] args) throws InterruptedException {
        //调用wait会提前是否锁吗？
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (LOCK) {
                    try {
                        log.debug("A get LOCK");
                        LOCK.wait();
                        log.debug("A wait finish");
                        while (true) {
                            Thread.sleep(1000);
                            log.debug("A enter loop");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "A").start();

        Thread.sleep(1000);

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (LOCK) {
                    log.debug("B get LOCK");
                    log.debug("exec B");
                    LOCK.notify();
                }
            }
        }, "B").start();
    }
}
