package com.calc.review.p5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/10/11
 */
public class DataImportThread extends Thread{

    private String path;

    private CyclicBarrier cyclicBarrier;

    public DataImportThread(String path,CyclicBarrier cyclicBarrier) {
        this.path = path;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println("开始导入。。。" + path + "数据的位置");

        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
