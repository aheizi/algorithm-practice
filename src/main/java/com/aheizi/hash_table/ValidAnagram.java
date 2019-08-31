package com.aheizi.hash_table;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangquan1 on 2019-08-31.
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class ValidAnagram {

    /**
     * 这是第一遍解法，存下两个字符串中的字符出现的次数，一个字符串用一个HashMap
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> sCharNumMap = getCharNumMap(s);
        Map<Character, Integer> tCharNumMap = getCharNumMap(t);
        return sCharNumMap.equals(tCharNumMap);
    }

    private static Map<Character, Integer> getCharNumMap(String s) {
        Map<Character, Integer> charNumMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charNumMap.containsKey(c)) {
                charNumMap.put(c, charNumMap.get(c) + 1);
            } else {
                charNumMap.put(c, 1);
            }
        }
        return charNumMap;
    }


    /**
     * 好像也没有优化多少
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> sCharNumMap = new HashMap<>();
        Map<Character, Integer> tCharNumMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char cS = s.charAt(i);
            if (sCharNumMap.containsKey(cS)) {
                sCharNumMap.put(cS, sCharNumMap.get(cS) + 1);
            } else {
                sCharNumMap.put(cS, 1);
            }

            char cT = t.charAt(i);
            if (tCharNumMap.containsKey(cT)) {
                tCharNumMap.put(cT, tCharNumMap.get(cT) + 1);
            } else {
                tCharNumMap.put(cT, 1);
            }
        }

        return sCharNumMap.equals(tCharNumMap);
    }


    public static void main(String[] args) {
        System.out.println(isAnagram1("anagram", "nagaram"));
        System.out.println(isAnagram1("rat", "car"));

        System.out.println(isAnagram2("anagram", "nagaram"));
        System.out.println(isAnagram2("rat", "car"));
    }

//    总结，可以用
//    int[] counter = new int[26];
//    for (int i = 0; i < s.length(); i++) {
//        counter[s.charAt(i) - 'a']++;
//        counter[t.charAt(i) - 'a']--;
//    }
//    相当于自己构建一个哈希表
}
