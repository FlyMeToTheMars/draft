package com.hugh.datastructure.binarytree.leecode;

import com.hugh.datastructure.binarytree.utils.TreeNode;

/**
 * @program: draft
 * @description: 最长同值路径
 * @author: Fly.Hugh
 * @create: 2020-08-15 05:28
 **/
public class LongestUnivaluePath {
    public static void main(String[] args) {

    }

    /**
    * @author Fly.Hugh
    * @Description
     * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
     *
     * 注意：两个节点之间的路径长度由它们之间的边数表示。
     *
     * 示例 1:
     *
     * 输入:
     *
     *               5
     *              / \
     *             4   5
     *            / \   \
     *           1   1   5
     * 输出:
     *
     * 2
     * 示例 2:
     *
     * 输入:
     *
     *               1
     *              / \
     *             4   5
     *            / \   \
     *           4   4   5
     * 输出:
     *
     * 2
     * 注意: 给定的二叉树不超过10000个结点。树的高度不超过1000。
     *
    * @Date 5:28 2020/8/15
    * @Param [root]
    * @return int
    **/
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return path;
    }

    private int path = 0;

    private int dfs(TreeNode root){
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int leftPath = root.left != null && root.left.val == root.val ? left + 1: 0;
        int rightPath = root.right != null && root.right.val == root.val ? right + 1: 0;
        path = Math.max(path, rightPath+leftPath);
        return Math.max(leftPath, rightPath);
    }
    /**
    * @author Fly.Hugh
    * @Description
     * 这道题目值得好好思考一下
     * 二叉树递归的难点就在于怎么构思：子节点向父节点返回的是什么?或者说，当前节点向其父节点返回的是什么?
     * 这题中，当前节点返回给父节点的值就是：
     *
     * 从当前节点出发，向下延伸与其值相同的最大深度
     *
     * 于是返回值分两种情况：
     * 1.                                    if( 如果当前节点与其左右节点都不相等)，那么深度为0，则返回0
     * 2. else，                             这个最大深度就取其 左右子树返回值中的较大者 + 1
     *
     * 然后，在上面这个dfs的遍历过程中，还可以做一些其他的事情，这题做的就是 计算路径长度。由于子树的返回值已经确定了，所以需要额外的一个全局变量。
    * @Date 8:14 2020/8/15
    **/
}
