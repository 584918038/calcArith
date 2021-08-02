package com.calc.review.leet3code;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * <p>
 * 示例 4:
 * <p>
 * 输入: s = ""
 * 输出: 0
 *
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/7/13
 */
public class Question3 {


    /**
     * * 输入: s = "abcabcbb"
     * * 输出: 3
     */
    public static int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> characterMap = new HashMap<>();
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        int len = 0;
        int maxLen = 0;

        while (left < chars.length) {

            if (null == characterMap.get(chars[right])) {

                characterMap.put(chars[right], right + 1);
                right++;
                len++;

            } else {

                maxLen = len;
                Integer oldInteger = characterMap.get(chars[right]);
                characterMap.put(chars[right], right + 1);
                len = len - oldInteger;
                left ++;
                len ++;
            }

        }
        return maxLen;
    }

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
