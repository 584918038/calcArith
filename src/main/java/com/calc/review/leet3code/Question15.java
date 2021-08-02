package com.calc.review.leet3code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：[]
 *  
 *
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/7/28
 */
public class Question15 {

    public List<List<Integer>> threeSum(int[] nums) {

        // 数组排序
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length;
        int status = 0;

        List<List<Integer>> results = new ArrayList<>();

        while (left < right) {

            int leftValue = target(nums[left] + nums[right - 1]);
            int searchValue = binarySearch(nums, leftValue, left, right);
            if (searchValue != Integer.MAX_VALUE) {

                List<Integer> result = new ArrayList<>();

                result.add(nums[left]);
                result.add(searchValue);
                result.add(nums[right - 1]);

                results.add(result);
            }

            if (status % 2 == 0) {
                left++;
                status++;
            } else {
                right--;
                status++;
            }
        }
        return results;
    }

    /**
     * 二分法
     */
    public int binarySearch(int[] nums, int target, int left, int right) {

        int l = left;
        int r = right;
        int midIndex = (left + right) / 2;

        while (l < r) {

            if (nums[midIndex] == target) {
                return nums[midIndex];
            }

            if (nums[midIndex] > target) {
                r = midIndex;
                midIndex = (l + r) / 2;
            } else {
                l = midIndex + 1;
                midIndex = (l + right) / 2;
            }
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 返回待查找值
     */
    public int target(int value) {

        if (value < 0) {
            return value - 2 * value;
        } else {
            return Math.abs(value);
        }
    }

    public static void main(String[] args) {

        int[] array = new int[]{-1, 0, 1, 2, -1, -4};
        Question15 q = new Question15();
        System.out.println(q.threeSum(array));
    }
}
