package com.calc.review.leet3code;

/**
 *
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/7/2
 */
public class Question26 {

    public static int removeDuplicates1(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int targetValue = nums[0];
        int nonReplayElem = 0;

        // 未操作过元素
        int status = 0;

        for (int i = 0; i < nums.length; i ++) {

            // 处理target元素并且复位status
            if (nums[i] > targetValue) {
                targetValue = nums[i];
                status = 0;
            }

            // 元素的移动
            if (nums[i] == targetValue && status == 0) {
                nums[nonReplayElem++] = nums[i];
                status = 1;
            }
        }
        return nonReplayElem;
    }


    public static int removeDuplicates(int[] nums) {

        if (nums.length == 0) {

            return 0;
        }

        int targetValue = nums[0];
        int nonReplayElem = 0;

        for (int i = 0; i < nums.length; i ++) {

            // 处理target元素并且复位status
            if (nums[i] > targetValue) {
                targetValue = nums[i];
            }

            if (nums[i] == targetValue){
                nums[nonReplayElem++] = nums[i];
            }

        }
        return nonReplayElem;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{3, 2, 2, 3, 5};

        System.out.println();
    }
}
