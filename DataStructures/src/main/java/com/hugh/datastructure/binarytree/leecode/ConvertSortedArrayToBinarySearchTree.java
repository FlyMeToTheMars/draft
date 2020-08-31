package com.hugh.datastructure.binarytree.leecode;

import com.hugh.datastructure.binarytree.utils.TreeNode;

/**
 * @program: draft
 * @description: 从有序数组中构建二叉查找树
 * @author: Fly.Hugh
 * @create: 2020-08-31 21:55
 **/
public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {

    }

    /**
    * @author Fly.Hugh
    * @Description 
     * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
     *
     * 本题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1。
     *
     * 示例:
     *
     * 给定有序数组: [-10,-3,0,5,9],
     *
     * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
     *
     *       0
     *      / \
     *    -3   9
     *    /   /
     *  -10  5
     *
    * @Date 21:57 2020/8/31
    * @Param [nums]
    * @return com.hugh.datastructure.binarytree.utils.TreeNode
    **/
    public TreeNode sortedArrayToBST(int[] nums) {
        // 双指针控制角标， 不断得把数组分成两块，然后在分开的块中取中点继续赋值。
        return toBST(nums, 0, nums.length - 1);
    }

    private TreeNode toBST(int[] nums, int sIdx, int eIdex) {
        // 注意循环停止的条件
        if(sIdx > eIdex) return null;
        int mIdex = (sIdx + eIdex) / 2;
        TreeNode root = new TreeNode(nums[mIdex]);
        root.left = toBST(nums, sIdx, mIdex - 1);
        root.right = toBST(nums, mIdex + 1, eIdex);
        return root;
    }
}