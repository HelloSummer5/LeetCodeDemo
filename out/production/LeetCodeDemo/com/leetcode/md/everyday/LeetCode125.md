### 题目描述

> 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
- 说明：本题中，我们将空字符串定义为有效的回文串。

示例1：
```
输入: "A man, a plan, a canal: Panama"
输出: true
```

示例2：
```
输入: "race a car"
输出: false
```

### 思路
回文常见的三种做法：双指针、栈、字符串反转
- 双指针：6ms
- 栈：8ms
- 字符串反转：6ms

### 代码
```java
class Solution {
    public boolean isPalindrome(String s) {
        // 过滤非字母数字字符
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                stringBuffer.append(Character.toLowerCase(c));
            }
        }
        // 双指针
        int start = 0, end = str.length() - 1;
        while (start < end) {
            if (Character.toUpperCase(str.charAt(start)) != Character.toUpperCase(str.charAt(end))) return false;
            start++;
            end--;
        }
        return true;
    }
}
```

- 本项目代码：[LeetCode125](https://github.com/HelloSummer5/LeetCodeDemo/blob/master/src/com/leetcode/everyday/LeetCode125.java "悬停显示")
