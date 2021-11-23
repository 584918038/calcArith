package com.calc.review.p5;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/10/13
 */
public class ConditionDemo {

    public static void main(String[] args) {

        Lock lock = new ReentrantLock();

        Condition condition = lock.newCondition();

        ConditionDemoWait conditionDemoWait = new ConditionDemoWait(lock,condition);
        ConditionDemoNotify conditionDemoNotify = new ConditionDemoNotify(lock,condition);

        conditionDemoWait.start();
        conditionDemoNotify.start();



    }
}
