package com.calc.review.leet3code;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/7/27
 */
public class Question205 {

    /**
     * 输入：s = "egg", t = "add"
     *
     */
    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        // 判断长度
        char[] chars = s.toCharArray();
        char[] chars2 = t.toCharArray();


        Map<Character, Character> mapTable = new HashMap<>();

        StringBuilder sb = new StringBuilder();

        int index = 0;

        while (index < chars.length) {

            if (mapTable.get(chars[index]) == null) {
                mapTable.put(chars[index], sb.toString().contains(String.valueOf(chars2[index])) ? '?' : chars2[index]);
                sb.append(mapTable.get(chars[index]));
            } else {
                sb.append(mapTable.get(chars[index]));
            }
            index++;
        }

        if (sb.toString().equals(t)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        Question205 q = new Question205();

        System.out.println(q.isIsomorphic("paper","title"));

    }
}
