package com.calc.review.leet3code;

import java.util.HashMap;

/**
 * 给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：3
 * <p>
 * 输入：points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出：4
 * <p>
 * 1 <= points.length <= 300
 * points[i].length == 2
 * -104 <= xi, yi <= 104
 * points 中的所有点 互不相同
 *
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/11/23
 */
public class Question149 {

    public int maxPoints(int[][] points) {

        if (points.length < 3) {
            return points.length;
        }

        int maxNum = 0;

        for (int i = 0; i < points.length; i++) {

            HashMap<Double, Integer> slopeMap = new HashMap<>();

            for (int j = 0; j < points.length; j++) {

                if (i != j) {

                    double slope = calcSlope(points[i],points[j]);

                    slopeMap.put(slope,null == slopeMap.get(slope) ? 1 : slopeMap.get(slope) + 1);

                    if (slopeMap.get(slope) > maxNum) {
                        maxNum = slopeMap.get(slope);
                    }
                }
            }
        }
        return maxNum + 1;
    }

    public double calcSlope(int[] x, int[] y) {

        return (x[1] - y[1]) / 1.0 / (x[0] - y[0]);
    }

    public static void main(String[] args) {

//        int[][] array = {{1,1},{2,2},{3,3}};
//        int[][] array = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        int[][] array = {{0,0},{1,-1},{1,1}};

        Question149 question149 = new Question149();

        int i = question149.maxPoints(array);

        System.out.println(i);
    }
}
