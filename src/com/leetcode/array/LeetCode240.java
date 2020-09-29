package com.leetcode.array;

import com.leetcode.util.PrintUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @NO  题目编号：LeetCode240
 * @Description 题目描述：
 *   在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 *   请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * @Example 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 *
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false。
 */
public class LeetCode240 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 4,  7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
//        int target = 5;
        int target = 20;
//        boolean result = findNumberIn2DArray(matrix, target);
        boolean result = findNumberIn2DArray1(matrix, target);
        PrintUtil.print(result);
    }

    /**
     * @Description 1.暴力破解
     * @param matrix
     * @param target
     * @Ps 时间复杂度O(m * n)
     * @return
     */
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) return true;
            }
        }
        return false;
    }

    /**
     * @Description 2.最优解
     * @param matrix
     * @param target
     * @Ps 时间复杂度O(m + n)
     * @return
     */
    public static boolean findNumberIn2DArray1(int[][] matrix, int target) {

        return false;
    }

}
