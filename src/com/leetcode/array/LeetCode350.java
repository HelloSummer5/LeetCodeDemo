package com.leetcode.array;

import com.leetcode.util.PrintUtil;

import java.util.*;

/**
 * @NO  题目编号：LeetCode350
 * @Description 题目描述：
 *   给定两个数组，编写一个函数来计算它们的交集。
 *
 * @Example 示例1:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * @Example 示例2:
 *  * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 *  * 输出: [4,9]
 */
public class LeetCode350 {
    public static void main(String[] args) {
//        int[] nums1 = {1,2,2,1};
//        int[] nums2 = {2,2};
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        PrintUtil.print(intersect(nums1, nums2));
    }

    /**
     * @Author 啵酱
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        // 第一个数组元素放入map
        for (int i = 0; i < nums1.length; i++) {
            int key = nums1[i];
            if (map.containsKey(key)){
                map.put(key, (Integer)map.get(key) + 1);
            }else {
                map.put(nums1[i], 1);
            }
        }
        // 第二个数组元素
        for (int i = 0; i < nums2.length; i++) {
            int key = nums2[i];
            if (map.containsKey(key) && (int)map.get(key) > 0){
                map.put(key, (int)map.get(key) - 1);
                res.add(key);
            }
        }
        // List<Integer> 转 int[]
        int[] result = res.stream().mapToInt(Integer::valueOf).toArray();
        return result;
    }

    /**
     * @Author 啵酱
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect1(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        String chr = "";
        for (int i = 0; i < nums2.length; i++) {
            if (set1.contains(nums2[i])){
                if (i == nums2.length - 1) {
                    chr += nums2[i];
                }else {
                    chr += nums2[i] + ",";
                }
            }
        }
        String str[] = chr.split(",");
        int result[] = new int[str.length];
        for(int i= 0; i< str.length; i++){
            result[i] = Integer.parseInt(str[i]);
        }
        return result;
    }

}
