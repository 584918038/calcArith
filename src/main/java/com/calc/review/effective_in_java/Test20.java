package com.calc.review.effective_in_java;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/8/9
 */
public class Test20 {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        Long sum = 0L;

        for (int i = 0; i < Integer.MAX_VALUE; i ++) {

            sum += i;
        }

        System.out.println("sum: " + sum);
        long end = System.currentTimeMillis();

        System.out.println("cost:" + (end - start));

    }
}
