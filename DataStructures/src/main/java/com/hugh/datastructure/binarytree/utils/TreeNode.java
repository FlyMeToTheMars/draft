package com.hugh.datastructure.binarytree.utils;

/**
 * @program: draft
 * @description: 二叉树节点
 * @author: Fly.Hugh
 * @create: 2020-08-12 04:58
 **/
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
