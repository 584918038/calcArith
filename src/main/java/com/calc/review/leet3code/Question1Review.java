package com.calc.review.leet3code;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 * <p>
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/8/2
 */
public class Question1Review {

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> localMap = new HashMap<>();

        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {

            int leftValue = target - nums[i];

            if (localMap.containsKey(leftValue)) {

                result[1] = i;
                result[0] = localMap.get(leftValue);
            } else {

                localMap.put(nums[i], i);
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
