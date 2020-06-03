package com.leetcode.everyday;

/**
 * @Date 2020/6/2
 * @NO  题目编号：LeetCode面试题64
 * @Description 题目描述：
 *    求1+2+…+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class LeetCodeFace64 {

    public static void main(String[] args) {
        System.out.println(sumNums(3));
    }

    /**
     * @Author 啵酱
     * @param n
     * @return
     */
    public static int sumNums(int n) {
        if (n == 1){
            return n;
        }
        return n + sumNums(n - 1);
    }
}
