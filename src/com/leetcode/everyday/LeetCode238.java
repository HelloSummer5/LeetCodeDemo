package com.leetcode.everyday;

/**
 * @Date 2020/6/4
 * @NO  题目编号：LeetCode238
 * @Description 题目描述：
 *    给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 * @Example 示例:
 *      输入: [1,2,3,4]
 *      输出: [24,12,8,6]
 */
public class LeetCode238 {

    public static void main(String[] args) {

    }

    /**
     * @Author 啵酱
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        // 前缀之积数组
        int left[] = new int[nums.length];
        left[0] = 1;
        // 后缀之积数组
        int right[] = new int[nums.length];
        left[right.length - 1] = 1;

        for (int i = 1; i < nums.length; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }

        right[right.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = nums[i + 1] * right[i + 1];
        }

        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            answer[i] = left[i] * right[i];
        }

        return answer;
    }
}
