package com.hugh.datastructure.binarytree.leecode;

import com.hugh.datastructure.binarytree.utils.TreeNode;
import com.hugh.datastructure.binarytree.utils.TreeUtils;

/**
 * @program: draft
 * @description: 树的高度
 * @author: Fly.Hugh
 * @create: 2020-08-12 06:56
 **/
public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode node = TreeUtils.generateTreeFromArray(3, 9, 20, null, null, 15, 7);
        int i = new MaximumDepthOfBinaryTree().maxDepth(node);
        System.out.println(i);
    }

    /**
    * @author Fly.Hugh
    * @Description 又是一种全新的递归形式
     * 再接触几种递归应该就能总结出属于我自己的递归之道。
     * 每次有一层都会加一。
     *
     * 求二叉树的最大深度，根的深度是0，其实就是在求离根节点距离最远的叶节点的和根节点的距离。
    * @Date 7:04 2020/8/12
    * @Param [root]
    * @return int
    **/
    public int maxDepth(TreeNode root) {
        return (root == null) ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
