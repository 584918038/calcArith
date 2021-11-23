package com.calc.review.leet3code;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
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
 * @since 2021/7/28
 */
public class Question1 {

    /**
     * nums = [2,7,11,15], target = 9
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {

        int[] result = new int[2];
        Map<Integer, Integer> localMap = new HashMap<>();

        int leftValue;
        for (int i = 0; i < nums.length; i++) {
            leftValue = target - nums[i];

            if (localMap.containsKey(leftValue)) {
                result[0] = localMap.get(leftValue);
                result[1] = i;
            } else {
                localMap.put(nums[i], i);
            }
        }

        return result;
    }

    /**
     * 失败的原因是无序！
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {

        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        while (leftIndex < rightIndex) {

            int sum = nums[leftIndex] + nums[rightIndex];

            if (sum == target) {
                int[] arr = new int[2];
                arr[0] = leftIndex;
                arr[1] = rightIndex;
                return arr;
            }

            if (sum > target) {

                rightIndex --;
            }else {
                leftIndex ++;
            }
        }
        return null;
    }

    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> storeMap = new HashMap<>();

        for (int i = 0; i < nums.length; i ++) {

            int preFindValue = target - nums[i];

            if (!storeMap.isEmpty() && null !=storeMap.get(preFindValue)) {

                int[] arr = new int[2];
                arr[0] = storeMap.get(preFindValue);
                arr[1] = i;
                return arr;
            }else {
                storeMap.put(nums[i],i);
            }
        }
        return null;
    }


    public static void main(String[] args) {

        int[] array = new int[]{3,2,4};
        int target = 6;

        Question1 q = new Question1();

        int[] ints = q.twoSum(array, target);

        for (int i = 0; i < ints.length; i ++) {

            System.out.println(ints[i]);
        }
    }
}
