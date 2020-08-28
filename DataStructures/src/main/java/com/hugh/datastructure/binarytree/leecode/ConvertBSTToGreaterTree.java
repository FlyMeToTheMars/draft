package com.hugh.datastructure.binarytree.leecode;

import com.hugh.datastructure.binarytree.utils.TreeNode;
import com.hugh.datastructure.binarytree.utils.TreeUtils;

/**
 * @Author Fly.Hugh
 * @Date 2020/8/28 3:00 下午
 * @Version 1.0
 **/
public class ConvertBSTToGreaterTree {
    public static void main(String[] args) {
        TreeNode treeNode = TreeUtils.generateTreeFromArray(5, 2, 13);
        ConvertBSTToGreaterTree ct = new ConvertBSTToGreaterTree();
        TreeNode root = ct.convertBST(treeNode);
    }

    /**
     * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，
     * 使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
     *
     *
     *
     * 例如：
     *
     * 输入: 原始二叉搜索树:
     *               5
     *             /   \
     *            2     13
     *
     * 输出: 转换为累加树:
     *              18
     *             /   \
     *           20     13
     *
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        traver(root);
        return root;
    }

    private int sum = 0;

    /**
     * BST的中序遍历就是从小到大,
     * 那么反过来就是从大到小,然后累加就好了.
     * @param root
     */
    private void traver(TreeNode root) {
        if(root == null) return;
        traver(root.right);
        sum += root.val;
        root.val = sum;
        traver(root.left);
    }
}
