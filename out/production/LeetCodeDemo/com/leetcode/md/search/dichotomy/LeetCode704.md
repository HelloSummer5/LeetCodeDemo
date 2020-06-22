### 题目描述

> 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。

示例1：
```
输入: nums = [-1,0,3,5,9,12], target = 9
输出: 4
解释: 9 出现在 nums 中并且下标为 4
```
示例2：
```
输入: nums = [-1,0,3,5,9,12], target = 2
输出: -1
解释: 2 不存在 nums 中因此返回 -1
```

### 思路
- 二分查找最基本的题
- [小灰漫画图解](https://baijiahao.baidu.com/s?id=1635498997846582026&wfr=spider&for=pc)

### 代码
```java
class Solution {
    public int search(int[] nums, int target) {
        int mid, start = 0, end = nums.length - 1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (target == nums[mid]) return mid;
            else if (nums[mid] < target) start = mid + 1;
            else if(nums[mid] > target) end = mid - 1;
        }
        return -1;
    }
}
```

- 本项目代码：[LeetCode704](https://github.com/HelloSummer5/LeetCodeDemo/blob/master/src/com/leetcode/search/dichotomy/LeetCode704.java "悬停显示")
