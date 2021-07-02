package com.calc.review.leet3code;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数
 *
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/6/30
 */
public class Question283 {

    public static void main(String[] args) {


    }

    public void moveZeroes(int[] nums) {

        // 区间范围[0~nums-1]
        int nonZeroIndex = 0;
        int temp;
        for (int i = 0; i < nums.length; i++) {

            if (0 != nums[i]) {

                if (i != nonZeroIndex) {
                    temp = nums[i];
                    nums[i] = nums[nonZeroIndex];
                    nums[nonZeroIndex] = temp;
                    nonZeroIndex++;
                } else {
                    nonZeroIndex++;
                }
            }
        }

    }
}
