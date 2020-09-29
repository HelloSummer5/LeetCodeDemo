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
//        int[][] matrix = {
//                {1, 4,  7, 11, 15},
//                {2, 5, 8, 12, 19},
//                {3, 6, 9, 16, 22},
//                {10, 13, 14, 17, 24},
//                {18, 21, 23, 26, 30}
//        };
        int[][] matrix = {};
        int target1 = 5;
        int target2 = 20;
//        PrintUtil.print(findNumberIn2DArray(matrix, target1));
        PrintUtil.println(findNumberIn2DArray1(matrix, target1));
//        PrintUtil.println(findNumberIn2DArray1(matrix, target2));
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
        // 判空
        if (matrix.length == 0 || matrix[0].length == 0) return false;

        // 从矩阵左下角元素为基准base
        int i = matrix.length - 1;
        int j = 0;

        // 如果target<base，base位置向上挪；target>base，base位置向右挪
        while (j < matrix[0].length && i >= 0) {
            if (target < matrix[i][j]) i--;
            else if (target > matrix[i][j]) j++;
            else return true;
        }

        return false;
    }

}
