package com.calc.review.leet3code;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/7/5
 */
public class Question75 {

    public static void sortColors(int[] nums) {

        // 计数法
        int[] array = new int[3];
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            array[nums[i]]++;
        }

        for (int i = 0; i < array[0]; i++) {
            nums[index++] = 0;
        }

        for (int i = 0; i < array[1]; i++) {
            nums[index++] = 1;
        }

        for (int i = 0; i < array[2]; i++) {
            nums[index++] = 2;
        }
    }

    public static void sortColors1(int[] nums) {

        // 三色排序
        int zero = -1;             // [-1.0] 无效区间，全年为0
        int two = nums.length;    // [nums.length....num.length -1]
        int temp;

        for (int i = 0; i < two; ) {

            if (nums[i] == 1) {
                i++;
                continue;
            }

            if (nums[i] == 2) {
                two--;
                temp = nums[i];
                nums[i] = nums[two];
                nums[two] = temp;
                continue;
            }

            if (nums[i] == 0) {

                zero++;
                temp = nums[i];
                nums[i] = nums[zero];
                nums[zero] = temp;
                i++;
            }
        }
    }

    public static void main(String[] args) {

        // [2,0,2,1,1,0]
        int[] arr = new int[]{2, 0, 2, 1, 1, 0};
        sortColors(arr);
    }
}
