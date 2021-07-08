package com.calc.review.leet3code;

/**
 * 给定一个已按照 升序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
 * <p>
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
 * <p>
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * <p>
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：numbers = [2,3,4], target = 6
 * 输出：[1,3]
 * <p>
 * 示例 3：
 * <p>
 * 输入：numbers = [-1,0], target = -1
 * 输出：[1,2]
 *
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/7/8
 */
public class Question167 {

    public static int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;
        int sum;

        while (left < right) {

            sum = numbers[left] + numbers[right];

            if (target == sum) {

                return new int[]{left + 1, right + 1};
            }

            if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return null;
    }


    public static int[] twoSum2(int[] numbers, int target) {

        // 方法2: 二分法查找
        int need;

        for (int i = 0; i < numbers.length; i ++) {

            need = target - numbers[i];

            int index = getIndex(numbers, need, 0, numbers.length);

            if (index != -1 && index != i) {

                return new int[]{Math.min(i + 1,index + 1),Math.max(i + 1,index + 1)};
            }

        }
        return null;
    }

    /**
     * 二分查找，查找元素
     */
    public static int getIndex(int[] array, int target, int left, int right) {

        int midIndex = (left + right) / 2;

        if (array[midIndex] == target) {
            return midIndex;
        }else if(left == right) {
            return -1;
        }

        if (target < array[midIndex]) {
            return getIndex(array, target, left, midIndex);
        } else {
            return getIndex(array, target, midIndex + 1, right);
        }
    }

    public static void main(String[] args) {

        // [1,2,3,4,4,9,56,90]
        // 8
        int[] array = new int[]{1,2,3,4,4,9,56,90};
        int target = 8;

        int[] ints = twoSum(array, target);

        for (int i = 0; i < ints.length; i++) {

            System.out.print(ints[i]);
        }

        // 二分查找
//        System.out.println(getIndex(array, 7, 0, array.length));
    }
}
