package com.hugh.datastructure.binarytree.leecode;

import com.hugh.datastructure.binarytree.utils.TreeNode;
import com.hugh.datastructure.binarytree.utils.TreeUtils;

/**
 * @Author Fly.Hugh
 * @Date 2020/8/13 14:17
 * @Version 1.0
 **/
public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode root = TreeUtils.generateTreeFromArray(1, 2, 3, 4, 5, 6, 7);

        InvertBinaryTree InvertBinaryTree = new InvertBinaryTree();
        TreeNode treeNode = InvertBinaryTree.invertTree(root);
        TreeUtils.preOrderTraverse(treeNode);
    }

    /**
     * 翻转树
     * Max Howell 被Google难住的题目
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public TreeNode inverTree_improve(TreeNode root) {
        if (root == null) return root;
        TreeNode left = root.left;
        root.left = inverTree_improve(root.right);
        root.right = inverTree_improve(left);
        return root;
    }
}
