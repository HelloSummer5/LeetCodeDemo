package com.leetcode.offer;

import com.leetcode.util.PrintUtil;

/**
 * @NO  题目编号：LeetCode剑指offer
 * @Description 题目描述：
 *   请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * @Example 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 */
public class LeetCodeOffer05 {
    public static void main(String[] args) {
        String s = "We are happy.";
        int target1 = 5;
        PrintUtil.println(replaceSpace(s));
    }

    /**
     * @Description 1.无脑暴力破解
     * @param s
     * @return
     */
    public String replaceSpace1(String s) {
        return s.replaceAll(" ", "%20");
    }

    /**
     * @Description 2.最优解
     * @param s
     * @Ps 时间复杂度O(n)
     * @return
     */
    public static String replaceSpace(String s) {
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') sb.append("%20");
            else sb.append(arr[i]);
        }
        return sb.toString();
    }

}
