### 题目描述

> 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
  '.' 匹配任意单个字符
  '*' 匹配零个或多个前面的那一个元素
所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。

##### 说明
- s 可能为空，且只包含从 a-z 的小写字母。
- p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。

示例1：
```
输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。
```
示例2：
```
输入:
s = "aa"
p = "a*"
输出: true
解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
```

示例3：
```
输入:
s = "ab"
p = ".*"
输出: true
解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
```

示例4：
```
输入:
s = "aab"
p = "c*a*b"
输出: true
解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
```

示例5：
```
输入:
s = "mississippi"
p = "mis*is*p*."
输出: false
```

### 思路
- 待更新

### 代码
```java
class Solution {
    public static boolean isMatch(String s, String p) {
            int lens = s.length(), lenp = p.length();
            boolean[][] dp = new boolean[lens + 1][lenp+1];
            // 初始化dp[0][0]
            dp[0][0] = true;
            for (int j = 1; j < lenp + 1; j++){
                if (p.charAt(j - 1) == '*' && dp[0][j - 2]){
                    dp[0][j] = true;
                }
            }
    
            for (int i = 1; i < lens + 1; i++) {
                for (int j = 1; j < lenp + 1; j++) {
                    // 末尾元素相匹配
                    if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (p.charAt(j - 1) == '*' && j >= 2) { // p末尾是*结尾
                        // s能够p末尾*的前一个元素匹配 | p倒数第二个字符是.
                        if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')
                            dp[i][j] = dp[i][j - 2] || dp[i - 1][j - 2] || dp[i - 1][j];
                        else
                            dp[i][j] = dp[i][j - 2];
                    }
                }
            }
            return dp[lens][lenp];
        }
}
```

- 本项目代码：[LeetCode10](https://github.com/HelloSummer5/LeetCodeDemo/blob/master/src/com/leetcode/everyday/LeetCode10.java "悬停显示")
