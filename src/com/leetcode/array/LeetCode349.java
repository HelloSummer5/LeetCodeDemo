package com.leetcode.array;

import com.leetcode.util.PrintUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * @NO  题目编号：LeetCode349
 * @Description 题目描述：
 *   给定两个数组，编写一个函数来计算它们的交集。
 *
 * @Example 示例1:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * @Example 示例2:
 *  * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 *  * 输出: [9,4]
 *
 * @Note:
 *   输出结果中的每个元素一定是唯一的。
 *   我们可以不考虑输出结果的顺序。
 */
public class LeetCode349 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
//        int[] nums1 = {4,9,5};
//        int[] nums2 = {9,4,9,8,4};
        PrintUtil.print(intersect(nums1, nums2));
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + "ms");

    }

    /**
     * @Author 啵酱
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        String chr = "";
        for (int i = 0; i < nums2.length; i++) {
            if (set1.contains(nums2[i])){
                 res.add(nums2[i]);
            }
        }
        int[] result = res.stream().mapToInt(Integer::valueOf).toArray();
        return result;
    }

}
