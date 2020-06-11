package com.leetcode.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2020/6/5
 * @NO  题目编号：LeetCode54
 * @Description 题目描述：
 *    给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * @Example 示例1:
 *      输入:
 *          [
 *            [ 1, 2, 3 ],
 *            [ 4, 5, 6 ],
 *            [ 7, 8, 9 ]
 *          ]
 *      输出: [1,2,3,6,9,8,7,4,5]
 *
 * @Example 示例2:
 *      输入:
 *          [
 *            [1, 2, 3, 4],
 *            [5, 6, 7, 8],
 *            [9,10,11,12]
 *          ]
 *       输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class LeetCode54 {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        spiralOrder1(matrix).forEach(item -> System.out.print(item));
        System.out.println("");

        int arr[] = spiralOrder(matrix);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    /**
     * @Author 啵酱
     * @param matrix
     * @return  原题号#54
     */
    public static List<Integer> spiralOrder1(int[][] matrix) {
        List res = new ArrayList();
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;
        while (true){
            // 从左向右
            for (int i = l; i <= r; i++)
                res.add(matrix[t][i]);
            if (++ t > b) break;
            // 从上到下
            for (int i = t; i <= b; i++)
                res.add(matrix[i][r]);
            if (l > --r) break;
            // 从右到左
            for (int i = r; i >= l; i--)
                res.add(matrix[b][i]);
            if (t > --b)break;
            // 从下到上
            for (int i = b; i >= t; i--)
                res.add(matrix[i][l]);
            if (++l > r)break;
        }
        return res;
    }

    public static int[] spiralOrder(int[][] matrix) {
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[r * b];
        while (true){
            // 从左向右
            for (int i = l; i <= r; i++)
                res[x++] = matrix[t][i];
            if (++ t > b) break;
            // 从上到下
            for (int i = t; i <= b; i++)
                res[x++] = matrix[i][r];
            if (l > --r) break;
            // 从右到左
            for (int i = r; i >= l; i--)
                res[x++] = matrix[b][i];
            if (t > --b)break;
            // 从下到上
            for (int i = b; i >= t; i--)
                res[x++] = matrix[i][l];
            if (++l > r)break;
        }
        return res;
    }
}
