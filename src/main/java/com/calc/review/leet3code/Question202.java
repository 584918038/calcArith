package com.calc.review.leet3code;

import java.util.HashMap;
import java.util.Map;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」定义为：
 * <p>
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果 可以变为  1，那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 true ；不是，则返回 false 。
 *  
 * 示例 1：
 * 输入：19
 * 输出：true
 * 解释：
 * <p>
 * 1 * 1 + 9 * 9 = 82
 * 8 * 8 + 2 * 2 = 68
 * 6 * 6 + 8 * 8 = 100
 * 1 * 1 + 0 * 0 + 0 * 0 = 1
 * <p>
 * 输入：n = 2
 * 输出：false
 *
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/7/22
 */
public class Question202 {

    public boolean isHappy(int n) {

        if (n == 1) {
            return true;
        }

        Map<Integer, Integer> initMap = new HashMap<>();
        initMap.put(n, 1);

        char[] chars = String.valueOf(n).toCharArray();
        int tempSum = 0;
        for (int i = 0; i < chars.length; i++) {

            int x = Integer.parseInt(String.valueOf(chars[i]));
            tempSum += Math.multiplyExact(x, x);
        }

        if (tempSum == 1) {
            return true;
        }

        if (null != initMap.get(tempSum)) {
            return false;
        }

        return isHappy(tempSum, initMap);
    }

    public boolean isHappy(int n, Map<Integer, Integer> lastMap) {

        lastMap.put(n, 1);
        char[] chars = String.valueOf(n).toCharArray();
        int tempSum = 0;
        for (int i = 0; i < chars.length; i++) {

            int x = Integer.parseInt(String.valueOf(chars[i]));
            tempSum += Math.multiplyExact(x, x);
        }

        if (tempSum == 1) {
            return true;
        }

        if (null != lastMap.get(tempSum)) {
            return false;
        }

        return isHappy(tempSum, lastMap);
    }

    public static void main(String[] args) {

        Question202 q = new Question202();

        System.out.println(q.isHappy(2));
    }
}
