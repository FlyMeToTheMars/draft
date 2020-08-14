package com.hugh.datastructure.binarytree.leecode;

import com.hugh.datastructure.binarytree.utils.TreeNode;

import java.util.ArrayList;

/**
 * @Author Fly.Hugh
 * @Date 2020/8/14 9:13
 * @Version 1.0
 **/
public class PathSum {
    public static void main(String[] args) {

    }

    /**
     * 给定一个int Sum，要判断是否存在一条路径，从Root到Leaf，各个节点的和加起来等于Sum.
     *
     * 一种新的类型的递归，返回值是bool，通过 || 的特性，不断向上返回bool.有一个为true就一直为true.
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == sum) return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
