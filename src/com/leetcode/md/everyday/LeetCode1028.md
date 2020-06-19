### 题目描述

> 我们从二叉树的根节点 root 开始进行深度优先搜索。
在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。（如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。
如果节点只有一个子节点，那么保证该子节点为左子节点。
给出遍历输出 S，还原树并返回其根节点 root。

>**注意题目已经给出TreeNode**

示例1：
![alt](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/04/12/recover-a-tree-from-preorder-traversal.png)

```
输入："1-2--3--4-5--6--7"
输出：[1,2,5,3,4,6,7]
```

示例2：
![alt](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/04/12/screen-shot-2019-04-10-at-114101-pm.png)

```
输入："1-2--3---4-5--6---7"
输出：[1,2,5,3,null,6,null,4,null,7]
```

示例3：
![alt](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/04/12/screen-shot-2019-04-10-at-114955-pm.png)

```
输入："1-401--349---90--88"
输出：[1,401,null,349,88,90]
```

### 思路
- 本周末更

### 代码
- 耗时：8ms
```
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode recoverFromPreorder(String S) {
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
}
```

- 本项目代码：[LeetCode1028](https://github.com/HelloSummer5/LeetCodeDemo/blob/master/src/com/leetcode/everyday/LeetCode1028.java "悬停显示")
