package com.leetcode.everyday;

/**
 * @Date 2020/6/20
 * @NO  题目编号：LeetCode10 正则表达式匹配
 * @Description 题目描述：
 *      给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *      '.' 匹配任意单个字符
 *      '*' 匹配零个或多个前面的那一个元素
 *
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * @Description 说明:
 *      s 可能为空，且只包含从 a-z 的小写字母。
 *      p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 *
 *
 * @Example 示例1:
 *      输入:
 *          s = "aa"
 *          p = "a"
 *      输出: false
 *      解释: "a" 无法匹配 "aa" 整个字符串。
 *
 * @Example 示例2:
 *      输入:
 *      s = "aa"
 *      p = "a*"
 *      输出: true
 *      解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 *
 */
public class LeetCode010 {

    public static void main(String[] args) {
        System.out.println(isMatch("a", "b*"));
    }

    /**
     * 啵酱
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        // s[i-1] == p[i-1]   ---->  继续往前遍历:dp[i][j]=dp[i-1][j-1]
        // s[i-1] != p[i-1]
        //  --> 1. p[i-1]是*
        //    --> 1.1 s[i-1] == p[i-2]   ==>
        //        -->  * 让p[i-1]出现0次：dp[i][j] = dp[i][j-2]
        //        -->  * 让p[i-1]出现1次：dp[i][j] = dp[i-1][j-2]
        //        -->  * 让p[i-1]出现>=2次：dp[i][j] = dp[i-1][j]
        //    --> 1.2 s[i-1] != p[i-2]  ==> 并未完全死刑：
        int lens = s.length(), lenp = p.length();
        boolean[][] dp = new boolean[lens + 1][lenp + 1];
        // 初始化dp[0][0]
        dp[0][0] = true;
        for (int j = 1; j < lenp + 1; j++){
            if (p.charAt(j - 1) == '*' && j >= 2){
                dp[0][j] = dp[0][j - 2];
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
                        // *让a重复0次、1次、>=2次
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j - 2] || dp[i - 1][j];
                    else
                        dp[i][j] = dp[i][j - 2];
                }
            }
        }
        return dp[lens][lenp];
    }

}
