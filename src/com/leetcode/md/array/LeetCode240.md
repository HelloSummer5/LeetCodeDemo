### 题目描述

> 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
  
示例1：

现有矩阵 matrix 如下：
```java  
  [
    [1,   4,  7, 11, 15],
    [2,   5,  8, 12, 19],
    [3,   6,  9, 16, 22],
    [10, 13, 14, 17, 24],
    [18, 21, 23, 26, 30]
  ]
```
  
```java
  给定 target = 5，返回  true。
  给定  target = 20，返回  false。
```

### 思路1
1. 暴力破解
### 思路2
- 从矩阵的左下角看，上方的数字都比其小，右方的数字都比其大，所以依据该规律去判断数字是否存在
- 设当前数字为 cur，目标数字为 target，当 target < cur 时，cur 更新为其上面的数字，当 target > cur 时，cur 更新为其右侧的数字，直到相等则返回 true，否则到了矩阵边界返回 false
- 时间复杂度：O(m+n)

### 代码
```java
class Solution {
  
}
```

- 本项目代码：[LeetCode240](https://github.com/HelloSummer5/LeetCodeDemo/blob/master/src/com/leetcode/array/LeetCode240.java "悬停显示")
