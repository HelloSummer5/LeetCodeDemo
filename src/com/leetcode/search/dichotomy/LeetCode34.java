package com.leetcode.search.dichotomy;

import com.leetcode.util.PrintUtil;

/**
 * @NO  题目编号：LeetCode34
 * @Description 题目描述：
 *      给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *   你的算法时间复杂度必须是 O(log n) 级别。
 *   如果数组中不存在目标值，返回 [-1, -1]。
 *
 * @Example 示例1:
 *      输入: nums = [5,7,7,8,8,10], target = 8
 *      输出: [3,4]
 *
 *      @Example 示例1:
 *      输入: nums = [5,7,7,8,8,10], target = 6
 *      输出: [-1,-1]
 */
public class LeetCode34 {

    public static void main(String[] args) {
        int[] res = searchRange(new int[]{5,7,7,8,8,10}, 8);
//        int[] res = searchRange(new int[]{1}, 1);
        PrintUtil.print(res);
    }

    private static int extremeInsertionIndex(int[] nums, int target, boolean isLeft) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] > target || (isLeft && target == nums[mid])) {
                end = mid - 1;
            }else {
                start = mid +  1;
            }
        }
        return start;
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        // 一轮二分找到左边角标
        int left = extremeInsertionIndex(nums, target, true);
        // 边界情况
        if (left == nums.length || nums[left] != target) {
            return res;
        }
        res[0] = left;
        // 二轮二分找到右边角标
        res[1] = extremeInsertionIndex(nums, target, false) - 1;
        return res;
    }
}
