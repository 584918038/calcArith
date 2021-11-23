package com.calc.review.p5;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/10/13
 */
public class ConditionDemoNotify extends Thread {

    private Lock lock;
    private Condition condition;

    public ConditionDemoNotify(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {



        try {
            System.out.println("begin - ConditionDemoNotify");
            lock.lock();
            condition.signal();
            System.out.println("end - ConditionDemoNotify");
        }finally {
            lock.unlock(); 
        }

    }
}
