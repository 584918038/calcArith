package com.calc.review.p5;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/10/25
 */
public class ForkJoinDemo extends RecursiveTask<Integer> {

    // 计算1~10的累加
    // 切割任务: 一个阈值2

    private final int THREAD_HOLD = 2;

    private int start;

    private int end;

    public ForkJoinDemo(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {

        int sum = 0;
        boolean canCompute = (end - start) <= THREAD_HOLD;

        if (canCompute) { // 不能分割

            for (int i = start; i <=  end; i ++) {
                System.out.println("start:" + start + "end-" + end);
                sum += i;
            }
        }else {

            int middle = (start + end) / 2;
            ForkJoinDemo left = new ForkJoinDemo(start,middle);
            ForkJoinDemo right = new ForkJoinDemo(middle + 1,end);

            left.fork();
            right.fork();

            Integer leftResult = left.join();
            Integer rightResult = right.join();

            sum = leftResult + rightResult;
        }
        return sum;
    }


    public static void main(String[] args) throws Exception{

        ForkJoinPool forkJoinPool = new ForkJoinPool();

        ForkJoinDemo forkJoinDemo = new ForkJoinDemo(1,10);

        ForkJoinTask<Integer> result = forkJoinPool.submit(forkJoinDemo);

        System.out.println(result.get());

    }
}
