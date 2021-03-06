### 题目描述

> 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
> 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

示例：
```
给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
```
### 思路
1. 遍历数组，求出target与数组元素的差
2. 如果key存在则返回map中的数组下标value，否则，重复步骤3
3. target与数组元素的差、数组下标分别放入HashMap中的key、value;
![](https://github.com/HelloSummer5/LeetCodeDemo/blob/master/src/com/leetcode/static/array/leetcode%231_1.gif)


### 代码
```java
public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key)){
                return new int[]{map.get(key), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
```

- 本项目代码：[LeetCode001](https://github.com/HelloSummer5/LeetCodeDemo/blob/master/src/com/leetcode/array/LeetCode001.java "悬停显示")
