package com.calc.review.leet3code;

/**
 * 题目:
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 说明:
 * <p>
 * 输入：nums = [3,2,2,3], val = 3
 * 输出：2, nums = [2,2]
 * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/7/2
 */
public class Question27 {

    public static int removeElement1(int[] nums, int val) {

        // 第一种做法: 采用标记的方法进行处理
        int nonValIndex = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != val) {
                nums[nonValIndex++] = nums[i];
            }
        }
        return nonValIndex;
    }

    public static int removeElement3(int[] nums, int val) {

        // 第二种做法: 遍历交换法,可以优化
        int nonValIndex = 0;
        int temp;

        for (int i = 0; i < nums.length; i++) {


            if (nums[i] != val) {

                if (i != nonValIndex) {
                    temp = nums[i];
                    nums[i] = nums[nonValIndex];
                    nums[nonValIndex] = temp;
                    nonValIndex++;
                } else {
                    nonValIndex++;
                }
            }
        }
        return nonValIndex;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{3, 2, 2, 3, 5};
        int val = 5;

        System.out.println(removeElement1(nums, val));
    }
}
