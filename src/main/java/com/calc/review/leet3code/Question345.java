package com.calc.review.leet3code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/7/12
 */
public class Question345 {

    static Map<Character, Character> map = new HashMap<>();

    static {

        map.put('a', 'a');
        map.put('A', 'a');
        map.put('e', 'a');
        map.put('E', 'a');
        map.put('I', 'a');
        map.put('i', 'a');
        map.put('o', 'a');
        map.put('O', 'a');
        map.put('u', 'a');
        map.put('U', 'a');

    }

    public static String reverseVowels(String s) {

        if (s.length() <= 1) {
            return s;
        }
        char temp;
        char[] chars = s.toCharArray();

        // 左右均为闭区间
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {

            while (null == map.get(chars[left]) && left < right) {
                left++;
            }

            while (null == map.get(chars[right]) && left < right) {
                right--;
            }

            if (left <= right) {

                temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;

                left++;
                right--;
            }

        }

        return String.valueOf(chars);
    }


    public static void main(String[] args) {

        /**
         * 示例 1：
         *
         * 输入："hello"
         * 输出："holle"
         *
         * leotcede
         */
        System.out.println(reverseVowels("hello"));

    }
}
