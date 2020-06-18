### 题目描述

> 爱丽丝参与一个大致基于纸牌游戏 “21点” 规则的游戏，描述如下：
  爱丽丝以 0 分开始，并在她的得分少于 K 分时抽取数字。 抽取时，她从 [1, W] 的范围中随机获得一个整数作为分数进行累计，其中 W 是整数。 每次抽取都是独立的，其结果具有相同的概率。
  当爱丽丝获得不少于 K 分时，她就停止抽取数字。 爱丽丝的分数不超过 N 的概率是多少？

示例1：
```
输入：N = 10, K = 1, W = 10
输出：1.00000
说明：爱丽丝得到一张卡，然后停止。
```

示例2：
```
输入：N = 6, K = 1, W = 10
输出：0.60000
说明：爱丽丝得到一张卡，然后停止。
在 W = 10 的 6 种可能下，她的得分不超过 N = 6 分。
```
示例3：
```
输入：N = 21, K = 17, W = 10
输出：0.73278
```
### 思路
[思路只能用视频描绘](https://www.bilibili.com/video/BV1CT4y1E7C2)
[文字题解](https://leetcode-cn.com/problems/longest-chunked-palindrome-decomposition/solution/bao-mu-ji-ti-jie-yi-chong-pu-tong-jie-fa-liang-cho/)

### 代码
```java
class Solution {
    public double new21Game(int N, int K, int W) {
        if (K == 0){
            return 1.0;
        }
        double[] f = new double[K + W];
        for (int i = K; i <= N; i++) {
            f[i] = 1.0;
        }
        // 初始化f[K - 1]即 f(16), Math.min以 N - K > W 导致概率超过1
        f[K - 1] = 1.0 * Math.min(N - K + 1, W) / W;
        for (int x = K - 1; x >= 1; x--) {
            f[x - 1] = f[x] - (f[x + W] - f[x]) / W;
        }
        return f[0];
    }
}
```

- 本项目代码：[LeetCode837](https://github.com/HelloSummer5/LeetCodeDemo/blob/master/src/com/leetcode/everyday/LeetCode837.java "悬停显示")
