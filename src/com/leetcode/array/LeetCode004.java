package com.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @NO  题目编号：LeetCode004
 * @Description 题目描述：
 *   给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 *   请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *   你可以假设 nums1 和 nums2 不会同时为空。
 *
 * @Example 示例1:
 *      nums1 = [1, 3]
 *      nums2 = [2]
 *      则中位数是 2.0
 *
 * @Example 示例2:
 *      nums1 = [1, 2]
 *      nums2 = [3, 4]
 *      则中位数是 (2 + 3)/2 = 2.5
 */
public class LeetCode004 {

    public static void main(String[] args) {
//        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

    /**
     * @Author 啵酱
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            arr[i] = nums1[i];
        }
        int index = nums1.length;
        for (int i = 0; i < nums2.length; i++) {
            arr[index] = nums2[i];
            index++;
        }
        Arrays.sort(arr);
        // 偶数，中位数相加
        double midIndex = (arr.length - 1.0) / 2.0;
        if (arr.length % 2 == 0){
            int middleIndex1 = (int)Math.ceil(midIndex);
            int middleIndex2 = (int)Math.floor(midIndex);
            return (arr[middleIndex1] + arr[middleIndex2]) / 2.0;
        }else {
            // 奇数
            return arr[(int)midIndex];
        }
    }

}
