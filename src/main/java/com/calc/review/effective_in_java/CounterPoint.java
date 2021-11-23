package com.calc.review.effective_in_java;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/8/18
 */
public class CounterPoint extends Point {

    private static final AtomicInteger counter = new AtomicInteger();

    public CounterPoint(int x, int y) {
        super(x, y);
        counter.incrementAndGet();
    }

    public static int numberCreated() {
        return counter.get();
    }
}
