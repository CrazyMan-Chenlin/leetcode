package com.nykj.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author chenlin
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     *  使用了滑动窗口法
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        //判空处理
        if (s == null || "".equals(s)) {
            return 0;
        }
        //循环遍历
        String[] splitArr = s.split("");
        StringBuilder tempStr = new StringBuilder();
        int maxLen = 0;
        for (String value : splitArr) {
            if (!tempStr.toString().contains(value)) {
                tempStr.append(value);
            } else {
                if (tempStr.length() >= maxLen) {
                    maxLen = tempStr.length();
                }
                tempStr = new StringBuilder(tempStr.substring(tempStr.indexOf(value) + 1) + value);
            }
        }
        return Math.max(maxLen, tempStr.length());
    }

    /**
     * 索引优化滑动窗口(来自LeetCode)
     * j代表不同前进的窗口，i代表重复时，窗口移动的位置
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s){
        int n = s.length(), ans = 0;
        // current index of character
        Map<Character, Integer> map = new HashMap<>();
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            //与原来最长子串比较
            ans = Math.max(ans, j - i + 1);
            //将索引作为值放到value中
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串。。。");
        String str = sc.next();
        System.out.println(lengthOfLongestSubstring2(str));
        sc.close();
    }
}
