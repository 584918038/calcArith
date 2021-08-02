package com.calc.review.leet3code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/7/20
 */
public class Question349 {

    public static int[] intersection(int[] nums1, int[] nums2) {

        Map<Integer, Integer> initMap = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();


        // 初始化map
        for (int key1 : nums1) {
            initMap.put(key1, null == initMap.get(key1) ? 1 : initMap.get(key1) + 1);
        }

        for (int key2 : nums2) {

            if (null != initMap.get(key2) && initMap.get(key2) > 0) {
                initMap.put(key2, initMap.get(key2) - 1);
                result.add(key2);
            }
        }

        int[] array = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {

            array[i] = result.get(i);
        }

        return array;
    }


    /**
     * [4,7,9,7,6,7]
     * [5,0,0,6,1,6,2,2,4]
     *
     * @param args
     */
    public static void main(String[] args) {

        /**
         * [1,2,2,1], nums2 = [2,2]
         */
        int[] num1 = new int[]{1, 2, 2, 1};
        int[] num2 = new int[]{2, 2};

        int[] intersection = intersection(num1, num2);

        for (int i = 0; i < intersection.length; i++) {

            System.out.println(intersection[i]);
        }
    }
}
