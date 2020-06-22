package com.leetcode.search.dichotomy;

/**
 * @NO  题目编号：LeetCode704
 * @Description 题目描述：
 *          我们正在玩一个猜数字游戏。 游戏规则如下：
 *      我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
 *      每次你猜错了，我会告诉你这个数字是大了还是小了。
 *      你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：
 *
 *      -1 : 我的数字比较小
 *      1 : 我的数字比较大
 *      0 : 恭喜！你猜对了！
 *
 * @Example 示例:
 *      输入: n = 10, pick = 6
 *      输出: 6
 */
public class LeetCode374 {

    private static final int target = 6;

    public static void main(String[] args) {
        System.out.println(guessNumber(10));
        System.out.println(11 / 2);
    }

    public static int guessNumber(int n) {
        int start = 1, end = n;
        int mid;
        while(start < end){
            // 在 Java的JDK的Collections和Arrays 提供的 binarySearch 方法中，中位数是这样取的：避免整型溢出
            mid = (start + end + 1) >>>  1;
            int guessNum = guess(mid);
            if(guessNum == 0) return mid;
            else if(guessNum == 1) start = mid;
            else if(guessNum == -1) end = mid - 1;
        }
        return -1;
    }

    /**
     * 官方预先定义接口，判断大小
     * @param t
     * @return
     */
    private static int guess(int t){
        if (t > target) return 1;
        else if (t < target) return -1;
        return 0;
    }
}
