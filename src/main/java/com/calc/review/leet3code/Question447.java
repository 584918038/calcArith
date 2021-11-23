package com.calc.review.leet3code;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * 给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。回旋镖 是由点 (i, j, k) 表示的元组 ，其中 i 和 j 之间的距离和 i 和 k 之间的欧式距离相等（需要考虑元组的顺序）。
 *
 * 返回平面上所有回旋镖的数量。
 *
 * 输入：points = [[0,0],[1,0],[2,0]]
 * 输出：2
 * 解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 *
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：2
 *
 * 输入：points = [[1,1]]
 * 输出：0
 *
 * @since 2021/11/23
 */
public class Question447 {

    public static void main(String[] args) {


    }

    public int numberOfBoomerangs(int[][] points) {

        int sum = 0;

        for (int i = 0; i < points.length; i ++) {

            HashMap<Integer,Integer> distanceMap = new HashMap<>();

            for (int j = 0; j < points.length; j ++) {

                if (i != j) {

                    int distance = calcDistance(points[i], points[j]);

                    distanceMap.put(distance,null == distanceMap.get(distance) ? 1 : distanceMap.get(distance) + 1);
                }
            }

            Iterator<Integer> iterator = distanceMap.keySet().iterator();
            while (iterator.hasNext()) {

                Integer key = iterator.next();

                sum += distanceMap.get(key) * (distanceMap.get(key) -1);
            }
        }
        return sum;
    }

    /**
     * 距离差
     */
    private int calcDistance(int[] x,int[] y) {

        return (x[0] - y[0]) * (x[0] - y[0]) + (x[1] - y[1]) * (x[1] - y[1]);
    }
}
