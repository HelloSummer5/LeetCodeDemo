package com.leetcode.everyday;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Date 2020/6/18
 * @NO  题目编号：LeetCode1028
 * @Description 题目描述：
 *    我们从二叉树的根节点 root 开始进行深度优先搜索。
 * 在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。（如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。
 * 如果节点只有一个子节点，那么保证该子节点为左子节点。
 * 给出遍历输出 S，还原树并返回其根节点 root。
 */
public class LeetCode1028 {

    public static void main(String[] args) {
        // listTreeNode(recoverFromPreorder("1-2--3--4-5--6--7"));
//         listTreeNode(recoverFromPreorder("1-2--3---4-5--6---7"));
        listTreeNode(recoverFromPreorder("1-401--349---90--88"));
    }

    /**
     * @Author 啵酱
     * @param S
     * @return
     */
    public static TreeNode recoverFromPreorder(String S) {
        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            int curLevel = 0;
            int curr = 0;
            // 计算当前节点level
            while (i < S.length() && S.charAt(i) == '-') {
                curLevel++;
                i++;
            }
            // 字符串变成数字
            while (i < S.length() && S.charAt(i) != '-'){
                curr = curr * 10 + S.charAt(i) - '0';
                i++;
            }
            // i加多了，减回来
            i--;
            TreeNode curNode = new TreeNode(curr);
            // ROOT入栈
            if (stack.isEmpty()){
                stack.push(curNode);
                continue;
            }
            // 栈中元素只保存未构建完毕子树的父节点，建完毕子树的节点删除
            while (stack.size() > curLevel){
                stack.pop();
            }
            // 构建树
            if (!stack.isEmpty()) {
                if (stack.peek().left != null) {
                    stack.peek().right = curNode;
                } else {
                    stack.peek().left = curNode;
                }
            }
            stack.push(curNode);

        }
        return stack.firstElement();
    }

    /**
     * 官方已定义类
     */
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    /**
     * 广度优先遍历二叉树(层序遍历)
     * @param treeNode
     */
    private static void listTreeNode(TreeNode treeNode){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(treeNode);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.println(node.val);
            if (node.left != null){
                queue.offer(node.left);
            }
            if (node.right != null){
                queue.offer(node.right);
            }
        }
    }
}
