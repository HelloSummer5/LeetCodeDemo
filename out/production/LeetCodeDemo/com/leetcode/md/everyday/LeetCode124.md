### 题目描述

> 给定一个非空二叉树，返回其最大路径和。
  本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。

示例1：
```
输入: [1,2,3]

       1
      / \
     2   3

输出: 6
```
示例2：
```
输入: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

输出: 42
```

### 思路
- 递归分别找到子节点最大路径更新，负数直接pass

### 代码
```java
class Solution {
    private int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
            dfs(root);
            return res;
        }
    
        private int dfs(TreeNode r) {
            if(r == null) return 0;
            // 如果子树路径和为负则应当置0表示最大路径不包含子树
            int left = Math.max(0, getMax(r.left)); 
            int right = Math.max(0, getMax(r.right));
            // 判断在该节点包含左右子树的路径和是否大于当前最大路径和
            res = Math.max(res, r.val + left + right); 
            return Math.max(left, right) + r.val;
        }
}
```

