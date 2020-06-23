### 题目描述

> 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
  你的算法时间复杂度必须是 O(log n) 级别。
  如果数组中不存在目标值，返回 [-1, -1]。

示例1：
```
输入: nums = [-1,0,3,5,9,12], target = 9
输出: 4
解释: 9 出现在 nums 中并且下标为 4
```

### 思路
> 关于target和数组关系有三种可能：
> 1. target中有一个无重复元素
> 2. target中有多个无重复元素<br>
>   2.1 由于是**有序**数组，重复元素必然挨在一起
> 3. target不在数组中

> 具体做法
- 1.初始化mid，进行一次二分查找并**返回start**
    - a) nums[mid] < target, start = mid + 1 = 3
    - b) 进入二轮循环，重新计算mid = 4；<br>
         end = mid - 1 = 3
    - c) 循环结束，返回start = 3
- 2.一轮二分查找之后的start赋值到res数组第一个元素<br>
  进行第二轮二分查找，得到最右边的下标
- 3.注意边界情况处理：
  - a) 输入：[1] 1
  - b) target在数组中不存在
   
![](https://hbimg.huabanimg.com/58580511ed6972e41eee57b8c4646e16306de44b9f2d-KuUH5x)
![](https://hbimg.huabanimg.com/0d3da1c26cf292e8d5eaecc797fea02dd356a361a338-7vZ51C)
![](https://hbimg.huabanimg.com/d21737fafca08c574547937194f2ddf8df3a498dcb7e-DvIhsM)
![](https://hbimg.huabanimg.com/9a9e94f54283433575ef87a1afaa8326bbbd92ddb2bc-bPbeKz)

![alt](https://pic.leetcode-cn.com/049e64ded6739e8bd6955a1d5e3ef76acc0aac0ad12909bdd58772dd6d465240-image.png)

> 总结
1. ```int mid = (left + right) / 2```是初级写法，是有 bug 的；
2. ```int mid = left + (right - left) / 2;```是正确的写法，说明你考虑到了整型溢出的风险；
3. ```int mid = (low + high) >>> 1;```  首先肯定是正确的写法，其实也是一个装 ❌ 的写法，理由上面已经叙述过了。

### 代码
```java
class Solution {
    private static int extremeInsertionIndex(int[] nums, int target, boolean isLeft) {
            int start = 0;
            int end = nums.length - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (nums[mid] > target || (isLeft && target == nums[mid])) {
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }
            return start;
        }
    
    public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int left = extremeInsertionIndex(nums, target, true);
        // assert that `leftIdx` is within the array bounds and that `target`
        if (left == nums.length || nums[left] != target) {
            return res;
        }
        res[0] = left;
        res[1] = extremeInsertionIndex(nums, target, false) - 1;
        return res;
    }
}
```
