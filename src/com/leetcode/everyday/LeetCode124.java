package com.leetcode.everyday;

import java.util.*;

/**
 * @Date 2020/6/20
 * @NO  题目编号：LeetCode10 正则表达式匹配
 * @Description 题目描述：
 *      给定一个非空二叉树，返回其最大路径和。
 *      本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * @Example 示例1:
 * 输入：  [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * 输出: 6
 *
 * @Example 示例2:
 *  输入: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 输出: 42
 */
public class LeetCode124 {

    private int ret = Integer.MIN_VALUE;

    public static void main(String[] args) {
        LeetCode124 demo = new LeetCode124();
        System.out.println(demo.maxPathSum(buildTree(new int[]{-10,9,20,15,7}, 0)));
    }

    /**
     * 啵酱
     * @param root
     * @return
     */
    public static int maxPathSum1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            res += node.val;
            if (node.left != null){
                queue.offer(node.left);
            }
            if (node.right != null){
                queue.offer(node.right);
            }
        }
        return res;
    }

    public int maxPathSum(TreeNode root) {
        getMax(root);
        return ret;
    }

    private int getMax(TreeNode r) {
        if(r == null) return 0;
        int left = Math.max(0, getMax(r.left)); // 如果子树路径和为负则应当置0表示最大路径不包含子树
        int right = Math.max(0, getMax(r.right));
        ret = Math.max(ret, r.val + left + right); // 判断在该节点包含左右子树的路径和是否大于当前最大路径和
        return Math.max(left, right) + r.val;
    }
        /**
         * 建树
         * @param arr
         * @return
         */
    public static TreeNode buildTree(int[] arr, int index) {
        TreeNode tn = null;
        if (index < arr.length) {
            Integer value = arr[index];
            if (value == null) {
                return null;
            }
            tn = new TreeNode(value);
            tn.left = buildTree(arr, 2*index+1);
            tn.right = buildTree(arr, 2*index+2);
            return tn;
        }
        return tn;
    }

    /**
     * 题目给的二叉树
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
