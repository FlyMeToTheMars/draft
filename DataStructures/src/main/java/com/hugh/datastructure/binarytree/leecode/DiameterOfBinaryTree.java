package com.hugh.datastructure.binarytree.leecode;

import com.hugh.datastructure.binarytree.utils.TreeNode;

/**
 * @Author Fly.Hugh
 * @Date 2020/8/13 11:33
 * @Version 1.0
 **/
public class DiameterOfBinaryTree {
    public static void main(String[] args) {

    }

    /**
     * 求二叉树的直径
     */
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getDiameter(root);
        return diameter;
    }

    public int getDiameter(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = getDiameter(node.left);
        int right = getDiameter(node.right);
        diameter = Math.max(diameter, (left + right));
        return 1 + Math.max(left, right);
    }
}
