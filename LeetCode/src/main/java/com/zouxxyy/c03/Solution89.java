package com.zouxxyy.c03;

/*
389. 找不同
给定两个字符串 s 和 t，它们只包含小写字母。

字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。

请找出在 t 中被添加的字母。



示例 1：

输入：s = "abcd", t = "abcde"
输出："e"
解释：'e' 是那个被添加的字母。
示例 2：

输入：s = "", t = "y"
输出："y"
示例 3：

输入：s = "a", t = "aa"
输出："a"
示例 4：

输入：s = "ae", t = "aea"
输出："a"


提示：

0 <= s.length <= 1000
t.length == s.length + 1
s 和 t 只包含小写字母
 */

/**
 * @author zxy
 */
public class Solution89 {

    public char oldFindTheDifference(String s, String t) {

        int[] counts = new int[26];

        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            counts[c - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (counts[i] == -1) {
                return (char) ('a' + i);
            }
        }

        return 'a';
    }

    public char findTheDifference(String s, String t) {

        int res = 0;

        for (char c : s.toCharArray()) {
            res ^= c;
        }

        for (char c : t.toCharArray()) {
            res ^= c;
        }

        return (char) res;
    }

}
