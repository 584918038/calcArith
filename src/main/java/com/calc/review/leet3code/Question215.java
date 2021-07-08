package com.calc.review.leet3code;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * <p>
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/7/7
 */
public class Question215 {


    /**
     * [3,2,1,5,6,4]
     * 2
     * <p>
     * [3,2,3,1,2,4,5,5,6]
     * 4
     *
     * @param args
     */
    public static void main(String[] args) {

        /**
         * []
         * 2
         * [-1,2,0]
         * 2
         */
        int[] array = new int[]{-1,2,0};
        int target = 2;
        int kthLargest = findKthLargest(array, target);

        System.out.println(kthLargest);
    }

    public static int findKthLargest2(int[] nums, int k) {

        if (nums.length == 1) {
            return nums[0];
        }

        // 三路快排的思想解决
        int zero = -1;
        int two = nums.length;
        int midValue = nums[0];
        int temp;

        for (int i = 0; i < two; ) {

            if (midValue == nums[i]) {
                i++;
                continue;
            } else if (nums[i] > midValue) {

                two--;
                temp = nums[i];
                nums[i] = nums[two];
                nums[two] = temp;
                continue;
            } else {

                zero++;
                temp = nums[i];
                nums[i] = nums[zero];
                nums[zero] = temp;
                i++;
            }
        }
        // 进入递归
        if (k == zero + 1 + 1) {
            return nums[two];
        } else if (k < zero + 1) {
            return findKthLargest(newArray(nums, two, nums.length), k);

        } else {
            return findKthLargest(newArray(nums, 0, zero + 1), k);
        }
    }

    public static int[] newArray(int[] array, int startIndex, int endIndex) {

        int[] arrays = new int[endIndex - startIndex];
        int k = 0;
        for (int i = startIndex; i < endIndex; i++) {

            arrays[k++] = array[i];
        }
        return arrays;
    }

    public static int findKthLargest(int[] nums, int k) {

        int[] array = new int[k];

        for (int i = 0; i < nums.length; i ++) {

            if (i < k) {
                array[i] = nums[i];
                continue;
            }
            if (nums[i] > array[getMinIndex(array)]) {

                array[getMinIndex(array)] = nums[i];
            }
        }
        return array[getMinIndex(array)];
    }

    /**
     * 返回最小值的下标
     * @param minArray
     * @return
     */
    public static int getMinIndex(int[] minArray) {

        int min = minArray[0];
        int index = 0;

        for (int i = 0; i < minArray.length; i ++) {

            if (min > minArray[i]) {
                min = minArray[i];
                index = i;
            }
        }
        return index;
    }
}
