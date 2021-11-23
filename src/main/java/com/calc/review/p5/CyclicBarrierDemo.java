package com.calc.review.p5;

import java.util.concurrent.CyclicBarrier;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/10/11
 */
public class CyclicBarrierDemo extends Thread{

    @Override
    public void run() {

        System.out.println("开始进行数据汇总和分析。。。");
    }

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(4,new CyclicBarrierDemo());

        new DataImportThread("path1",cyclicBarrier).start();
        new DataImportThread("path2",cyclicBarrier).start();
        new DataImportThread("path3",cyclicBarrier).start();


        // todo 希望三个线程执行结束之后，在做一个汇总处理



    }
}
