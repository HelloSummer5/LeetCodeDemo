package com.leetcode.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2020/6/1
 * @NO  题目编号：LeetCode1431
 * @Description 题目描述：
 *    给你一个数组 candies 和一个整数 extraCandies ，其中 candies[i] 代表第 i 个孩子拥有的糖果数目。
 * 对每一个孩子，检查是否存在一种方案，将额外的 extraCandies个糖果分配给孩子们之后，此孩子有最多的糖果。
 * 注意，允许有多个孩子同时拥有最多的糖果数目。
 *
 * @Example 示例1:
 *      输入：candies = [2,3,5,1,3], extraCandies = 3
 *      输出：[true,true,true,false,true]
 *      解释：
 *      孩子 1 有 2 个糖果，如果他得到所有额外的糖果（3个），那么他总共有 5 个糖果，他将成为拥有最多糖果的孩子。
 *      孩子 2 有 3 个糖果，如果他得到至少 2 个额外糖果，那么他将成为拥有最多糖果的孩子。
 *      孩子 3 有 5 个糖果，他已经是拥有最多糖果的孩子。
 *      孩子 4 有 1 个糖果，即使他得到所有额外的糖果，他也只有 4 个糖果，无法成为拥有糖果最多的孩子。
 *      孩子 5 有 3 个糖果，如果他得到至少 2 个额外糖果，那么他将成为拥有最多糖果的孩子。
 *
 * @Example 示例2:
 * 输入：candies = [4,2,1,1,2], extraCandies = 1
 * 输出：[true,false,false,false,false]
 * 解释：只有 1 个额外糖果，所以不管额外糖果给谁，只有孩子 1 可以成为拥有糖果最多的孩子。
 *
 * @Example 示例2:
 * 输入：candies = [12,1,12], extraCandies = 10
 * 输出：[true,false,true]
 */
public class LeetCode1431 {

    public static void main(String[] args) {
         int[] candies = {2, 3, 5, 1, 3};
        List<Boolean> res = kidsWithCandies(candies, 3);
//        int[] candies = {4, 2, 1, 1, 2};
//        List<Boolean> res = kidsWithCandies(candies, 1);
//        int[] candies = {12, 1, 12};
//        List<Boolean> res = kidsWithCandies(candies, 10);
        System.out.print("[");
        res.forEach(item -> System.out.print(item + ","));
        System.out.print("]");

    }

    /**
     * @Author 啵酱
     * @param candies
     * @param extraCandies
     * @return
     */
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // 找出最多糖果个数
        int maxCandyCount = 0;
        for (int i = 0; i < candies.length; i++)
            maxCandyCount = candies[i] > maxCandyCount ? candies[i] : maxCandyCount;
        List<Boolean> res = new ArrayList();
        // 找出正解
        for (int i = 0; i < candies.length; i++) {
            int tmp = candies[i] + extraCandies;
            res.add(tmp >= maxCandyCount);
        }
        return res;
    }
}
