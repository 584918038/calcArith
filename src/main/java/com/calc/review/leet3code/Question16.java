package com.calc.review.leet3code;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * <p>
 * 返回这三个数的和。
 * <p>
 * 假定每组输入只存在恰好一个解。
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * <p>
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 *
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/11/19
 */
public class Question16 {

    /**
     * 求解差值最小即可
     */
    public int threeSumClosest(int[] nums, int target) {

        int diffValue = Integer.MAX_VALUE;

        // 排序
        Arrays.sort(nums);

        if (nums.length < 3) {
            return -1;
        }
        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                if (Math.abs(nums[left] + nums[right] + nums[i] - target) < Math.abs(diffValue)) {
                    diffValue = target - (nums[left] + nums[right] + nums[i]);

                    if (diffValue > 0) {
                        left ++;
                    }else {
                        right--;
                    }
//
//                    while (left < right && nums[left] == nums[left - 1]) left++;
//                    while (left < right && nums[right] == nums[right + 1]) right--;

                } else if (nums[left] + nums[right] + nums[i] - target > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return target - diffValue;
    }

    /**
     * [1,1,1,0]
     * 100
     * 2
     * 3
     * <p>
     * [0,2,1,-3]
     * 1
     *
     * @param args
     */
    public static void main(String[] args) {

        Question16 q = new Question16();

//        int[] array = new int[]{0,2,1,-3};
//        int[] array = new int[]{-1,2,1,-4};
        int[] array = new int[]{1,1,1,0};
        int target = 100;
//        int target = 1;

        int i = q.threeSumClosest(array, target);

        System.out.println(i);
    }
}
