### 题目描述

> 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。

示例1：
```
输入: [1,2,3,4]
输出: [24,12,8,6]
```
- 说明: **请不要使用除法，且在 O(n) 时间复杂度内完成此题**。
- 进阶：你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）

### 思路
有空补，欢迎催更

### 代码
```java
class Solution {
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
```

- 本项目代码：[LeetCode238](https://github.com/HelloSummer5/LeetCodeDemo/blob/master/src/com/leetcode/everyday/LeetCode238.java "悬停显示")
