package com.calc.review.effective_in_java;


import sun.misc.Cleaner;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/8/10
 */
public class Room implements AutoCloseable{

    private static class State implements Runnable{

        @Override
        public void run() {

        }
    }
    @Override
    public void close() throws Exception {

    }
}
