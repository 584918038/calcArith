package com.calc.review.leet3code;

import java.util.*;

/**
 * 输入:
 * "tree"
 *
 * 输出:
 * "eert"
 *
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 *
 * 输入:
 * "Aabb"
 *
 * 输出:
 * "bbAa"
 *
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 */
public class Question451 {

    /**
     * @param args
     */
    public static void main(String[] args) {

//        StringBuilder res = new StringBuilder("xuenhanABCD");
//
//        ss.append("ABC",0,3);
//        res.append("ABC".toCharArray(),0,1);
//        int preInsertIndex = 3;
//
//        String frontString = res.toString().substring(0, preInsertIndex + 1);
//        String tailString = res.toString().substring(preInsertIndex + 1);
//
//        System.out.println("frontString: " + frontString);
//
//        System.out.println("tailString: " + tailString);

        Question451 question = new Question451();

        String tree = question.frequencySort("tree");
        System.out.println("result: " + tree);


    }

    public String frequencySort(String s) {

        HashMap<Character,Integer> result = new HashMap<>();

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i ++) {

            result.put(chars[i],null == result.get(chars[i]) ? 1: result.get(chars[i]) + 1);
        }

        int[] arrayIndex = new int[result.size()];
        int size = 0;

        HashMap<Character,Integer> midResult = new HashMap<>();

        StringBuilder res = new StringBuilder();

        Set<Map.Entry<Character, Integer>> entries = result.entrySet();

        Iterator<Map.Entry<Character, Integer>> iterator = entries.iterator();
        int kIndex = 0;

        while (iterator.hasNext()) {

            // 待处理的key 和  value
            Map.Entry<Character, Integer> next = iterator.next();

            // 出现的key
            Character key = next.getKey();
            // 出现的频率
            Integer value = next.getValue();
            // 记录出现的频率
            arrayIndex[kIndex] = value;

            if (res.length() == 0) {

                for (int i = 0; i < value; i ++) {
                    res.append(key);
                }
                size ++;
            }else {
                int preInsertIndex = insertSort(arrayIndex, value, size);
                // 切割字符串
                // front string
                String frontString = res.substring(0, preInsertIndex);
                String tailString = res.substring(preInsertIndex);

                res = new StringBuilder();
                res.append(frontString);
                for (int i = 0; i < value; i ++) {
                    res.append(key);
                }
                res.append(tailString);
                size ++;
            }
            kIndex ++;
        }
        return res.toString();
    }

    /**
     * 得到插入的位置
     * 当前必为一个有序数组
     * 插入排序算法,并返回当前元素前面元素值的和
     *
     * @param size 为当前数组实际存储非0元素数量
     */
    public int insertSort(int[] sourceArray,int preInsertValue,int size) {

        if (size == 0) {
            sourceArray[0] = preInsertValue;
            return 0;
        }
        int temIndex = 0;

        // 得到插入的下标
        for (int i = 0; i < sourceArray.length; i++) {

            if (sourceArray[i] >= preInsertValue) {
                temIndex = i;
                break;
            }
        }
        // 数组移动
        for (int i = size - 1; i >= temIndex; i --) {

            sourceArray[i+1] = sourceArray[i];
        }
        // 返回和
        int sum = 0;
        for (int i = 0 ; i < temIndex; i ++) {
            sum = sum + sourceArray[i];
        }
        return sum;
    }
}
