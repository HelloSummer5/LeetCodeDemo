### 题目描述

> 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
  初始化 A 和 B 的元素数量分别为 m 和 n。

示例：
```
输入:
A = [1,2,3,0,0,0], m = 3
B = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]
```
说明：
- A.length == n + m

### 思路
- 本题采用归并排序思想
- 从第二个数组中最大的元素开始遍历（从最小的开始要往后挪动元素，会增加时间复杂度）
- 下图从左至右观看

![alt](https://hbimg.huabanimg.com/357141ebd03d33b870bb1941a073965516d5e1584858-P4a7GR)
![alt](https://hbimg.huabanimg.com/192ab0f59791ec263208ce4bbb877598fb6ea9ab62d4-nWaFku)
![alt](https://hbimg.huabanimg.com/ea50a4555382897c12c720ed6b9fd53cf14eb61e7125-U3y2bm)
![alt](https://hbimg.huabanimg.com/bae4405771e31f5d9eb0f4594e3ff95687c89222a916-HU2tqV)

### 代码
```java
class Solution {
    public static boolean isMatch(String s, String p) {
        public static void merge(int[] A, int m, int[] B, int n) {
            int idx1 = m - 1;
            int idx2 = n - 1;
            int tail = m + n - 1;
            while(idx2 > 0){
                if (A[idx1] > B[idx2]) {
                    A[tail--] = A[idx1--];
                }else {
                    A[tail--] = B[idx2--];
                }
            }
            // A、B中只可能有一个剩余元素
            // A中有剩余元素
            while (idx1 > 0){
                A[tail--] = A[idx1--];
            }
            // B中有剩余元素
            while (idx2 > 0){
                A[tail--] = B[idx2--];
            }    
        }
    }
}
```

- 本项目代码：[LeetCodeFace10.01](https://github.com/HelloSummer5/LeetCodeDemo/blob/master/src/com/leetcode/array/LeetCodeFace10_01.java "悬停显示")
