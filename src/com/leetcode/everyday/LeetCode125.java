package com.leetcode.everyday;

import java.util.Stack;

/**
 * @Date 2020/6/19
 * @NO  题目编号：LeetCode125
 * @Description 题目描述：
 *      给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *      说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * @Example 示例1:
 *      输入: "A man, a plan, a canal: Panama"
 *      输出: true
 *
 * @Example 示例2:
 *      输入: "race a car"
 *      输出: false
 *
 * @Expend 正则表达式科普文章：https://blog.csdn.net/qq_26462567/article/details/101870973
 */
public class LeetCode125 {

    public static void main(String[] args) {
        System.out.println(isPalindrome2("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome2("race a car"));
        System.out.println(isPalindrome2("0P"));
        System.out.println(7 / 2);
    }

    /**
     * @param s
     * @return 方法1 双指针
     * @Author 啵酱
     */
    public static boolean isPalindrome1(String s) {
        // 过滤非字母数字字符, \\W ==>  [^a-zA-Z0-9]，面试时用正则可能还会问另一种方法
        String str = s.replaceAll("\\W", "");
        // 双指针
        int start = 0, end = str.length() - 1;
        while (start < end) {
            if (Character.toUpperCase(str.charAt(start)) != Character.toUpperCase(str.charAt(end))) return false;
            start++;
            end--;
        }
        return true;
    }

    /**
     * @param s
     * @return 方法2 反转字符串
     * @Author 啵酱
     */
    public static boolean isPalindrome3(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        // 去除非字母非数字
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                stringBuffer.append(Character.toLowerCase(c));
            }
        }
        // 反转比较字符串
        StringBuffer stringBufferRev = new StringBuffer(stringBuffer).reverse();
        return stringBuffer.toString().equals(stringBufferRev.toString());
    }

    /**
     * @param s
     * @return 方法3 栈
     * @Author 啵酱
     */
    public static boolean isPalindrome2(String s) {
        Stack stack = new Stack();
        // 去除非字母非数字
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                stringBuffer.append(Character.toLowerCase(c));
            }
        }
        // 将前一半字符串入栈
        int l = stringBuffer.length();
        for (int i = 0; i < l / 2; i++) {
            stack.push(stringBuffer.charAt(i));
        }
        // 栈里元素与后部分字符串比较
        int start = l % 2 == 1 ? l / 2 + 1 : l / 2; // 取中间数往后开始遍历
        for (int i = start; i < l; i++) {
            if ((char)stack.peek() == stringBuffer.charAt(i)){
                stack.pop();
            }else return false;
        }

        return true;
    }

}
