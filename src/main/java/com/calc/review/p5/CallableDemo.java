package com.calc.review.p5;

import java.util.concurrent.*;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/8/10
 */
public class CallableDemo implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("当前线程: " + Thread.currentThread().getName()) ;
        return "天不生我徐思思，漫漫古道如长夜~";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Future<String> submit = executorService.submit(new CallableDemo());

        System.out.println(Thread.currentThread().getName() + "-" + submit.get());

    }
}
