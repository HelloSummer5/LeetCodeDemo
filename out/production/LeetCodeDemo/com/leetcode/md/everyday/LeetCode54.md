### 题目描述

> 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
> 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

示例1：
```
输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
输出: [1,2,3,6,9,8,7,4,5]
```
示例2：
```
输入:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
输出: [1,2,3,4,8,12,11,10,9,5,6,7]
```

### 思路
放入HashMap

### 代码
```java
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List res = new ArrayList();
        if(matrix.length == 0) return res;
        int l = 0; int r = matrix[0].length - 1; int t = 0; int b = matrix.length - 1;
        while (true){
            // 从左向右
            for (int i = l; i <= r; i++)
                res.add(matrix[t][i]);
            if (++ t > b) break;
            // 从上到下
            for (int i = t; i <= b; i++)
                res.add(matrix[i][r]);
            if (l > --r) break;
            // 从右到左
            for (int i = r; i >= l; i--)
                res.add(matrix[b][i]);
            if (t > --b)break;
            // 从下到上
            for (int i = b; i >= t; i--)
                res.add(matrix[i][l]);
            if (++l > r)break;
        }
        return res;
    }
}
```

- 本项目代码：[LeetCode54](https://github.com/HelloSummer5/LeetCodeDemo/blob/master/src/com/leetcode/everyday/LeetCode54.java "悬停显示")
