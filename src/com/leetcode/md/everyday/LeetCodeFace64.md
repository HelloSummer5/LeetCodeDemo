### 题目描述

> 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。

示例1：
```
输入: n = 3
输出: 6
```

示例2：
```
输入: n = 9
输出: 45
```
- 限制：1 <= n <= 10000

### 思路
递归
### 代码
```java
class Solution {
    public int sumNums(int n) {
        // 设置结束条件
        if(n == 1){
            return n;
        }
        return n + sumNums(n - 1);
    }
}
```

- 本项目代码：[LeetCodeFace64](https://github.com/HelloSummer5/LeetCodeDemo/blob/master/src/com/leetcode/everyday/Face64.java "悬停显示")
