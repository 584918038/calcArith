package com.calc.review.leet3code;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 * <p>
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * <p>
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 *
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/7/7
 */
public class Question88 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // 双指针解法
        int firstIndex = 0;
        int secondIndex = 0;
        int total = m + n;
        int[] newArray = new int[total];

        for (int i = 0; i < total; i++) {

            if (secondIndex == n) {

                newArray[i] = nums1[firstIndex++];

            } else if (firstIndex == m) {

                newArray[i] = nums2[secondIndex++];

            } else if (nums1[firstIndex] < nums2[secondIndex]) {

                newArray[i] = nums1[firstIndex++];
            } else {

                newArray[i] = nums2[secondIndex++];
            }
        }

        for (int i = 0; i < total; i++) {

            nums1[i] = newArray[i];
        }
    }

    public static void main(String[] args) {

        int[] array1 = new int[]{2};
        int m = 1;
        int[] array2 = new int[]{1};
        int n = 1;
        merge(array1, m, array2, n);

        for (int i = 0; i < m + n; i++) {

            System.out.println(array1[i]);
        }
    }
}
