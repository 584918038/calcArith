package com.calc.review.leet3code;

import java.util.*;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母都恰好只用一次。
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * 输入: strs = [""]
 * 输出: [[""]]
 *
 *  输入: strs = ["a"]
 *  输出: [["a"]]
 *
 *  1 <= strs.length <= 104
 *  0 <= strs[i].length <= 100
 *  strs[i] 仅包含小写字母
 *
 *
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/11/19
 */
public class Question49 {

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> lists = new ArrayList<>();

        String[] sortStr = new String[strs.length];

        HashMap<String,Integer> maps = new HashMap<>();

        // 对strs里面的字符串进行排序
        for (int i = 0; i < strs.length; i ++) {

            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            sortStr[i] = Arrays.toString(chars);
        }

        // 针对性做处理
        for (int i = 0; i < sortStr.length; i ++) {

            List<String> list = new ArrayList<>();

            if (null != maps.get(sortStr[i])) continue;
            maps.put(sortStr[i],1);
            for (int j = i; j < sortStr.length; j ++) {

                if (Objects.equals(sortStr[i], sortStr[j])) {
                    list.add(strs[j]);
                }
            }
            lists.add(list);
        }
        return lists;
    }

    public static void main(String[] args) {

        Question49 question49 = new Question49();

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = question49.groupAnagrams(strs);

    }
}
