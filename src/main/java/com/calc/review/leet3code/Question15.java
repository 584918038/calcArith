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

        // 升序排序
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        HashMap<Integer, Integer> initMap = new HashMap<>();

        int firstValue = 0;
        int secondValue = 0;
        int midLeftValue = 0;
        int leftValue = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            firstValue = nums[i];
            secondValue = nums[i + 1];
            midLeftValue = firstValue + secondValue;

            if (midLeftValue > 0) {
                leftValue = -midLeftValue;
            } else {
                leftValue = Math.abs(midLeftValue);
            }

            if (initMap.containsKey(leftValue)) {

                List<Integer> result = new ArrayList<>();
                result.add(firstValue);
                result.add(secondValue);
                result.add(leftValue);

                results.add(result);
            } else {

                initMap.put(leftValue, i);
            }
        }
        return results;
    }

    public static void main(String[] args) {

    }
}
