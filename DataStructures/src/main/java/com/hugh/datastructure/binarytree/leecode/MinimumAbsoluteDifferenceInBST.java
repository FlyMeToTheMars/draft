package com.hugh.datastructure.binarytree.leecode;

import com.hugh.datastructure.binarytree.utils.TreeNode;

/**
 * @Author Fly.Hugh
 * @Date 2020/9/1 12:06 下午
 * @Version 1.0
 **/
public class MinimumAbsoluteDifferenceInBST {
    public static void main(String[] args) {

    }

    /**
     * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
     *
     * 示例：
     *
     * 输入：
     *
     *    1
     *     \
     *      3
     *     /
     *    2
     *
     * 输出：
     * 1
     *
     * 解释：
     * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
     * 
     *
     * 提示：
     *
     * 树中至少有 2 个节点。
     * 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 相同
     *
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        find(root);
        return min;
    }

    private void find(TreeNode root) {
        if(root==null) return;
        find(root.left);
        if (pre != null) {
            // 中序遍历BST 严格递增
            min = Math.min(min,root.val - pre.val);
        }
        pre = root;
        find(root.right);
    }

    // BST的性质要利用起来 中序遍历，保存前一个节点
    int min = Integer.MAX_VALUE;
    TreeNode pre = null;
}
