package com.leetcode.array;

import com.leetcode.util.PrintUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @NO  题目编号：面试题LeetCode10.01
 * @Description 题目描述：
 *   给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 *
 * @Example 示例:
 *      输入:
 *      A = [1,2,3,0,0,0], m = 3
 *      B = [2,5,6],       n = 3
 *
 *      输出: [1,2,2,3,5,6]
 */
public class LeetCodeFace10_01 {

    public static void main(String[] args) {
//        int m = 3, n = 3;
//        int[] A = new int[]{1, 2 , 3, 0, 0, 0};
//        int[] B = new int[]{2, 5, 6};
        int m = 0, n = 1;
        int[] A = new int[]{0};
        int[] B = new int[]{1};
        merge(A, m, B, n);
        PrintUtil.print(A);
    }

    /**
     * @Author 啵酱
     * @param A
     * @param m
     * @param B
     * @param n
     * @Description 代码精简版，看不懂可以根据md先看下后面懂图解易懂版代码
     */
    public static void merge(int[] A, int m, int[] B, int n) {
        int idx1 = m - 1;
        int idx2 = n - 1;
        int tail = m + n - 1;
        while(idx2 > 0){
            if (A[idx1] > B[idx2]) {
                A[tail--] = A[idx1--];
            }else {
                A[tail--] = B[idx2--];
            }
        }
        // A、B中只可能有一个剩余元素
        // A中有剩余元素
        while (idx1 > 0){
            A[tail--] = A[idx1--];
        }
        // B中有剩余元素
        while (idx2 > 0){
            A[tail--] = B[idx2--];
        }
    }

    /**
     * @Author 啵酱
     * @param A
     * @param m
     * @param B
     * @param n
     * @Description 图解易懂版
     */
    public static void merge1(int[] A, int m, int[] B, int n) {
        int idx1 = m - 1;
        int idx2 = n - 1;
        int tail = m + n - 1;
        while(idx2 > 0){
            if (A[idx1] > B[idx2]) {
                A[tail] = A[idx1];
                idx1--;
                tail --;
            }else {
                A[tail] = B[idx2];
                idx2--;
                tail--;
            }
        }
        // A、B中可能有剩余元素
        // A中有剩余元素
        while (idx1 > 0){
            A[tail] = A[idx1];
            tail--;
            idx1--;
        }
        // B中有剩余元素
        while (idx2 > 0){
            A[tail] = B[idx2];
            tail--;
            idx2--;
        }
    }

}
