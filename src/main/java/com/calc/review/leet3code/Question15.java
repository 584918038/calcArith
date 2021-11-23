package com.calc.review.leet3code;

import java.util.*;

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

    public List<List<Integer>> threeSum1(int[] nums) {

        // 数组排序
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length;

        List<List<Integer>> results = new ArrayList<>();


        while (left < right) {

            int leftValue = target(nums[left] + nums[right - 1]);
            int searchValue = binarySearch(nums, leftValue, left + 1, right - 1);
            if (searchValue != Integer.MAX_VALUE) {

                List<Integer> result = new ArrayList<>();

                result.add(nums[left]);
                result.add(searchValue);
                result.add(nums[right - 1]);

                if (results.size() == 0) {

                    results.add(result);
                } else {
                    List<Integer> integers = results.get(results.size() - 1);

                    if (!(integers.get(0) == nums[left] && integers.get(2) == nums[right - 1])) {

                        results.add(result);
                    }
                }
            }

            if (searchValue > 0) {
                left++;
            } else {
                right--;
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

        if (value >= 0) {
            return value - 2 * value;
        } else {
            return Math.abs(value);
        }
    }

    /**
     * 查找表两个map解决问题
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {

        List<List<Integer>> lists = new ArrayList<>();

        HashMap<Integer, Integer> initMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // 待查找的值
            int preValue = -nums[i];
            // 这样子不就分解成两个数的和为0了么
            for (int j = i; j < nums.length; j++) {

                if (j + 1 < nums.length) {

                    // 待处理的target
                    int target = preValue - nums[j + 1];

                    if (!initMap.isEmpty() && null != initMap.get(target)) {

                        List<Integer> list = new ArrayList<>();

                        list.add(nums[i]);
                        list.add(nums[j + 1]);
                        list.add(initMap.get(target));

                        lists.add(list);
                    } else {
                        initMap.put(nums[i], i);
                    }

                }
            }
        }
        return lists;
    }

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> lists = new ArrayList<>();

        if (null == nums || nums.length < 3) {
            return lists;
        }
        // 排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i ++) {

            if(nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i -1]) continue;

            int left = i + 1;
            int right = nums.length -1;
            int target = -nums[i];

            while (left < right) {

                if (nums[left] + nums[right] == target) {

                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    lists.add(list);

                    left ++;
                    right --;

                    while (left < right && nums[left] == nums[left -1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right --;
                }else if (nums[left] + nums[right] < target) {
                    left ++;
                }else {
                    right --;
                }
            }
        }
        return lists;
    }

    /**
     * -1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4
     * <p>
     * [[-4,0,4],[-4,1,3],[-3,0,3],[-3,1,2],[-2,0,2],[-1,0,1]]
     * <p>
     * [[-4,0,4],[-4,1,3],[-3,-1,4],[-3,0,3],[-3,1,2],[-2,-1,3],[-2,0,2],[-1,-1,2],[-1,0,1]]
     */
    public static void main(String[] args) {

        int[] array = new int[]{-1, 0, 1, 2, -1, -4};
        Question15 q = new Question15();
        System.out.println(q.threeSum(array));
    }
}
