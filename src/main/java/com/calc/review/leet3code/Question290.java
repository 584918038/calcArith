package com.calc.review.leet3code;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * <p>
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * <p>
 * 示例1:
 * <p>
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 *
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/7/26
 */
public class Question290 {

    public boolean wordPattern(String pattern, String s) {

        // 判断长度
        char[] chars = pattern.toCharArray();
        String[] stringArray = s.split(" ");
        if (chars.length != stringArray.length || pattern.length() == 0) {
            return false;
        }

        Map<String, Character> mmp = new HashMap<>();
        StringBuilder sb = new StringBuilder("");

        int index = 0;

        while (index < chars.length) {

            if (mmp.get(stringArray[index]) == null) {

                mmp.put(stringArray[index], sb.toString().contains(String.valueOf(chars[index])) ? '?' : chars[index]);
                sb.append(mmp.get(stringArray[index]));
            } else {
                sb.append(mmp.get(stringArray[index]));
            }
            index++;
        }

        if (sb.toString().equals(pattern)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        Question290 q = new Question290();

        String pattern = "abba";
        String s = "dog cat cat fish";

        System.out.println(q.wordPattern(pattern, s));

    }
}
