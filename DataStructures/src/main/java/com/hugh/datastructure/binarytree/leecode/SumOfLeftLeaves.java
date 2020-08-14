package com.hugh.datastructure.binarytree.leecode;

import com.hugh.datastructure.binarytree.utils.TreeNode;

import static com.hugh.datastructure.binarytree.utils.TreeUtils.generateTreeFromArray;

/**
 * @program: draft
 * @description: 左叶子之和
 * @author: Fly.Hugh
 * @create: 2020-08-15 04:17
 **/
public class SumOfLeftLeaves {
    public static void main(String[] args) {
        TreeNode root = generateTreeFromArray(3,9,20,null,null,15,7);
        int i = new SumOfLeftLeaves().sumOfLeftLeavesNiubi(root);
        System.out.println(i);
    }


    /**
    * @author Fly.Hugh
    * @Description
     * 计算给定二叉树的所有左叶子之和。
     *
     * 示例：
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
     *
     * 递归解法一：
     * 深度优先遍历，很简单，问题的关键就在于什么是左节点。
     *
    * @Date 5:05 2020/8/15
    * @Param [root]
    * @return int
    **/
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if(root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }

        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
        return sum;
    }

    private int sum;

    //==================================================更牛逼的迭代>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    /**
    * @author Fly.Hugh
    * @Description
     * 完全从语义出发，虽然写起来更麻烦一点，用了两个判断，但是让人一看就懂，牛逼。
    * @Date 5:15 2020/8/15
    * @Param [root]
    * @return int
    **/
    public int sumOfLeftLeavesNiubi(TreeNode root) {
        if (root == null) return 0;
        if (isLeaf(root.left)) return root.left.val + sumOfLeftLeaves(root.right);
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    private boolean isLeaf(TreeNode root) {
        if (root == null) {
            return false;
        }

        return root.left == null && root.right == null;
    }

}
