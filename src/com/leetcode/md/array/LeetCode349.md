### 题目描述

> 给定两个数组，编写一个函数来计算它们的交集。
示例1：
```
输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2]
```
示例2：
```
输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[9,4]
```

### 思路
有空补，欢迎在线催更。

### 代码
```java
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
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
```

- 本项目代码：[LeetCode349](https://github.com/HelloSummer5/LeetCodeDemo/blob/master/src/com/leetcode/array/LeetCode349.java "悬停显示")
