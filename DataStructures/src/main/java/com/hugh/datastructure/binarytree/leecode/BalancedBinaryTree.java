package com.hugh.datastructure.binarytree.leecode;

import com.hugh.datastructure.binarytree.utils.TreeNode;
import com.hugh.datastructure.binarytree.utils.TreeUtils;

/**
 * @Author Fly.Hugh
 * @Date 2020/8/13 10:42
 * @Version 1.0
 **/
public class BalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode root = TreeUtils.generateTreeFromArray(1, 2, 2, 3, null, null, 3, 4, null, null, 4);
        TreeUtils.preOrderTraverse(root);

        BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
        boolean balanced = balancedBinaryTree.isBalanced(root);
        System.out.println(balanced);

    }

    /**
     * 判断是否是平衡二叉树（每个节点的子数深度不超过1）
     * 借助外面的变量实现递归，加上了一个尾部遍历，第三次接触这种递归方式
     */
    private boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        getMaxDepth(root);
        return flag;
    }

    public int getMaxDepth(TreeNode node){
        if(node == null) return 0;
        int left = getMaxDepth(node.left);
        int right = getMaxDepth(node.right);
        if(Math.abs(left - right) > 1) flag = false;
        return 1 + Math.max(left, right);
    }
}
