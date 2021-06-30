package com.calc.review.leet3code;

/**
 * @author xuenhan
 */
public class BinarySearch {

    public static void main(String[] args) {

        int[] array = new int[]{1, 3, 5, 7, 9, 11, 18};

        int index = binary(array, 0,array.length -1, 12);

        System.out.println("当前元素所在下标为:" + index);

    }

    public static int binary(int[] array, int l, int r, int target) {

        // 在区间范围内查找[...]左右均为闭区间
        int midIndex = (r + l) / 2;

        while (l <= r) {

            if (target == array[midIndex]) {
                return midIndex;
            }

            if (target < array[midIndex]) {

                return binary(array, l, midIndex - 1, target);

            } else {

                return binary(array, midIndex + 1, r, target);
            }
        }
        return -1;
    }
}
