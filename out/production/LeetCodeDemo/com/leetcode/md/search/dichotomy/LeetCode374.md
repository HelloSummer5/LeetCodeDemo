### 题目描述

> 我们正在玩一个猜数字游戏。 游戏规则如下：
  我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
  每次你猜错了，我会告诉你这个数字是大了还是小了。
  你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：

```
-1 : 我的数字比较小
 1 : 我的数字比较大
 0 : 恭喜！你猜对了！
```

示例1：
```
输入: nums = [-1,0,3,5,9,12], target = 9
输出: 4
解释: 9 出现在 nums 中并且下标为 4
```

### 关于中位数取法的思考
- 1.最初学习二分法的时候，中位数的索引是这样的：
```java
int mid = (left + right) / 2;
```
- 2.后来被告知在 left 和 right 很大的时候，left + right 会发生整型溢出，变成负数，这是一个 bug 得改！于是写成：
```java
int mid = left + (right - left) / 2;
```
- 然后又被告知 mid = left + (right - left) // 2 在 right 很大、 left 是负数且很小的时候， right - left 也有可能超过 int 类型能表示的最大值，只不过一般情况下 left 和 right 表示的是数组索引值，left 是非负数，因此 right - left 溢出的可能性很小。
- 3.最后，在 Java 的 JDK 的 Collections 和 Arrays 提供的 binarySearch 方法里看到了，中位数是这样取的：
```java
int mid = (low + high) >>> 1;
```
- 怎么又变成 + 了，一头雾水啊，会整型溢出吗？后来查了查资料，有可能会整型溢出的，不过结果依然正确。下面是原因：
> left + right 在发生整型溢出以后，会变成负数，此时如果除以 22 ，mid 是一个负数，但是经过无符号右移，可以得到在不溢出的情况下正确的结果。

首先解释“无符号右移”，在 Java 中，无符号右移运算符 >>> 和右移运算符 >> 的区别如下：
- 右移运算符 >> 在右移时，丢弃右边指定位数，左边补上符号位；
- 无符号右移运算符 >>> 在右移时，丢弃右边指定位数，左边补上 00，也就是说，对于正数来说，二者一样，而负数通过 >>> 后能变成正数。

了解了这一点，就能够理解 Java 中用 int mid = (low + high) >>> 1; 的原因了，关键不在 + ，而是“无符号右移”，在 Java 的 Collections 和 Arrays 提供的 binarySearch 方法里，low 和 high 都表示索引值，它们都是非负数，即使相加以后整型溢出，结果还是正确的，“位运算”本身就比其它运算符快，因此使用 + 和“无符号右移”可以说是既快又好的做法。
如果你用 Java 写的话，不妨做下面的试验：
用 + 和除法，不能通过，提示也很清楚了。

![alt](https://pic.leetcode-cn.com/049e64ded6739e8bd6955a1d5e3ef76acc0aac0ad12909bdd58772dd6d465240-image.png)

> 总结
1. ```int mid = (left + right) / 2```是初级写法，是有 bug 的；
2. ```int mid = left + (right - left) / 2;```是正确的写法，说明你考虑到了整型溢出的风险；
3. ```int mid = (low + high) >>> 1;```  首先肯定是正确的写法，其实也是一个装 ❌ 的写法，理由上面已经叙述过了。

### 代码
```java
class Solution {
    public int search(int[] nums, int target) {
        public int guessNumber(int n) {
                int start = 0, end = n;
                int mid = 0;
                while(start < end){:
                    mid = (start + end + 1) >>> 1;
                    int guessNum = guess(mid);
                    if(guessNum == 0) return mid;
                    else if(guessNum == 1) start = mid;
                    else if(guessNum == -1) end = mid - 1;
                }
                return -1;
            }
    }
}
```

