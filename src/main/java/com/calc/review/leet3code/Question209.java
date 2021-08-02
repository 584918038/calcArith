package com.calc.review.leet3code;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * <p>
 * 示例 2：
 * <p>
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * <p>
 * 示例 3：
 * <p>
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/7/13
 */
public class Question209 {

    public static void main(String[] args) {

        int[] array = new int[]{1,1,1,1,1,1,1,1};
        int target = 11;

        System.out.println(minSubArrayLen(target,array));
    }

    public static int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int right = -1;
        int currentLength = Integer.MAX_VALUE;
        int sum = 0;


        while (left < nums.length) {

            if (right + 1 < nums.length && sum < target) {

                sum = sum + nums[++right];
            } else{ //  if (left + 1 < nums.length)

                sum = sum - nums[left++];
            }

            if (sum >= target) {

                currentLength = Math.min(currentLength, right - left + 1);
            }

        }

        if (currentLength == Integer.MAX_VALUE) {

            return 0;
        }
        return currentLength;
    }
}
