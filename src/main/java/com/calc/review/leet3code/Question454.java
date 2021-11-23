package com.calc.review.leet3code;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 * <p>
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 * <p>
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 * <p>
 * 输出:
 * 2
 * <p>
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 *
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/8/19
 */
public class Question454 {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        HashMap<Integer, Integer> oneAndTwoMaps = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {

            for (int j = 0; j < nums2.length; j++) {

                Integer key = nums1[i] + nums2[j];
                oneAndTwoMaps.put(key, null == oneAndTwoMaps.get(key) ? 1 : oneAndTwoMaps.get(key) + 1);
            }
        }

        HashMap<Integer, Integer> threeAndFourMaps = new HashMap<>();

        int sum = 0;

        for (int i = 0; i < nums3.length; i++) {

            for (int j = 0; j < nums4.length; j++) {

                Integer key = nums3[i] + nums4[j];

                // sum 对比
                sum += null == oneAndTwoMaps.get(-key) ? 0 : oneAndTwoMaps.get(-key);
            }
        }

        return sum;
    }

    public static void main(String[] args) {

//          *A = [1, 2]
//          *B = [-2, -1]
//          *C = [-1, 2]
//          *D = [0, 2]
        Question454 q = new Question454();

        int[] A = new int[]{1,2};
        int[] B = new int[]{-2,-1};
        int[] C = new int[]{-1,2};
        int[] D = new int[]{0,2};

        System.out.println(q.fourSumCount(A,B,C,D));
    }
}
