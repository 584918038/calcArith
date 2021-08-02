package com.calc.review.leet3code;

import java.util.HashMap;

/**
 * 有效的字母异位词
 * <p>
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/7/22
 */
public class Question242 {

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> initMap = new HashMap<>();
        int operateSum = 0;

        for (Character c : s.toCharArray()) {

            initMap.put(c, initMap.get(c) == null ? 1 : initMap.get(c) + 1);
            operateSum++;
        }

        for (Character removeC : t.toCharArray()) {

            Integer count = initMap.get(removeC);

            if (null == count) {
                return false;
            }

            if (count < 1) {
                return false;
            }

            initMap.put(removeC, --count);
            operateSum--;
        }

        return operateSum == 0;
    }

}
