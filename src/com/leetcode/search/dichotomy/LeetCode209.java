package com.leetcode.search.dichotomy;

import java.util.Arrays;

/**
 * @NO  题目编号：LeetCode209
 * @Description 题目描述：
 *      给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 *
 * @Example 示例1:
 *      输入：s = 7, nums = [2,3,1,2,4,3]
 *      输出：2
 *      解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * 进阶：
 *  如果你已经完成了 O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 *
 * @PS: 涉及连续子数组的问题，通常有两种思路：一是滑动窗口、二是前缀和。
 */
public class LeetCode209 {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }

    /**
     * 前缀和解法
     * @param s
     * @param nums
     * @return
     * @Description 时间复杂度O(nlogn)
     */
    public static int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n + 1];
        // 为了方便计算，令 size = n + 1
        // sums[0] = 0 意味着前 0 个元素的前缀和为 0
        // sums[1] = A[0] 前 1 个元素的前缀和为 A[0]
        // 以此类推
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int target = s + sums[i - 1];
            int bound = Arrays.binarySearch(sums, target);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
