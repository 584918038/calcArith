package com.calc.review.leet3code;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/7/9
 */
public class Question125 {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";

        System.out.println(isPalindrome(s));

    }

    public static boolean isPalindrome(String s) {

        String regex = "[A-Za-z0-9]";
        char[] chars = s.toCharArray();
        if (chars.length == 1)
            return true;

        int left = 0;
        int right = chars.length - 1;

        while (left < right) {

            if (!String.valueOf(chars[left]).matches(regex)) {
                left++;
            } else if (!String.valueOf(chars[right]).matches(regex)) {
                right--;
            }

            // A -- 65
            // a -- 97
            // diff 32
            if (String.valueOf(chars[left]).matches(regex) && String.valueOf(chars[right]).matches(regex)) {

                chars[left] = chars[left] >= 97 ? (char) (chars[left] - 32) : chars[left];
                chars[right] = chars[right] >= 97 ? (char) (chars[right] - 32) : chars[right];

                if (chars[left] != chars[right]) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}
