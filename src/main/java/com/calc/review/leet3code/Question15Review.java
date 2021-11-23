package com.calc.review.leet3code;

import java.util.ArrayList;
import java.util.Arrays;
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
 * @since 2021/8/06
 */
public class Question15Review {


    public List<List<Integer>> threeSum(int[] nums) {

        if (null == nums || nums.length < 3) {
            return new ArrayList<>();
        }

        // 数组排序
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();

        // 双指针处理该问题
        // 出现的两个问题  1. left right
        for (int i = 0; i < nums.length - 1; i++) {
            int target = nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重

            while (left < right) {

                if (nums[left] + nums[right] + target == 0) {

                    List<Integer> result = new ArrayList<>();

                    result.add(target);
                    result.add(nums[left]);
                    result.add(nums[right]);

                    results.add(result);

                    while (left < right && nums[left] == nums[left + 1]) left ++;
                    while (left < right && nums[right] == nums[right - 1]) right --;

                    left++;
                    right--;
                } else if (nums[left] + nums[right] + target > 0) {

                    right--;

                } else {
                    left++;
                }


            }
        }

        return results;
    }

    public static void main(String[] args) {

        int[] array = new int[]{0,0,0};
        Question15Review q = new Question15Review();
        System.out.println(q.threeSum(array));
    }
}
