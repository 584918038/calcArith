//package com.calc.review.leet3code;
//
//import java.util.*;
//
///**
// * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
// * <p>
// * 示例 1:
// * <p>
// * 输入:
// * "tree"
// * <p>
// * 输出:
// * "eert"
// * <p>
// * 解释:
// * 'e'出现两次，'r'和't'都只出现一次。
// * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
// *
// * @author 徐恩晗 xshlxx@126.com
// * @since 2021/7/27
// */
//public class Question451 {
//
//    /**
//     * @param args
//     */
//    public static void main(String[] args) {
//
//
//    }
//
//    public String frequencySort(String s) {
//
//        char[] chars = s.toCharArray();
//        Map<Character, Integer> map = new TreeMap<>();
//
//        for (int i = 0; i < chars.length; i++) {
//
//            map.put(chars[i], map.get(chars[i]) == null ? 1 : map.get(chars[i]) + 1);
//        }
//
//        List<Map.Entry<String, String>> list = new ArrayList<>((Collection<? extends Map.Entry<String, String>>) map.entrySet());
//        //升序排序
//        Collections.sort(list, Comparator.comparing(Map.Entry::getValue));
//
//        StringBuilder res = new StringBuilder();
//
//        return "";
//    }
//}
