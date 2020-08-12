package com.hugh.datastructure.binarytree.leecode;

import com.hugh.datastructure.binarytree.utils.TreeNode;
import com.hugh.datastructure.binarytree.utils.TreeUtils;

/**
 * @Author Fly.Hugh
 * @Date 2020/8/12 15:01
 * @Version 1.0
 **/
public class BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        TreeNode root = TreeUtils.generateTreeFromArray(-10,9,20,null,null,15,7);
        BinaryTreeMaximumPathSum binaryTreeMaximumPathSum = new BinaryTreeMaximumPathSum();
        int i = binaryTreeMaximumPathSum.maxPathSum(root);
        System.out.println(i);
    }

    /**
     * 求二叉树中的最大路径和
     * 原题描述：
     * 给定一个非空二叉树，返回其最大路径和。
     * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
     * 示例 1:
     *
     * 输入: [1,2,3]
     *
     *        1
     *       / \
     *      2   3
     *
     * 输出: 6
     *
     * 示例 2:
     *
     * 输入: [-10,9,20,null,null,15,7]
     *
     *    -10
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * 输出: 42
     *
     * -------------------------------------------------------
     *
     * 题意：从树中任意一个节点出发，寻找最大的路径和，就是在该节点的 子树 中寻找以该节点所在的一条路径，使得该路径上的节点值之和最大。
     * 从下而上进行分析求解。
     * 官方题解中有个贡献值的概念：
     *
     * 1、空节点的最大贡献值等于 0。
     * 2、非空节点的最大贡献值等于节点值与其子节点中的最大贡献值之和（对于叶节点而言，最大贡献值等于节点值）,考虑到如果叶节点都为负值时，只是单纯引入最大贡献值的子节点也是不太恰当的，所以如果两个子节点都为负值时，此节点的最大贡献值为它本身的值。
     *
     * 这里的贡献值呢，就是如果把该节点作为路径的一个节点，它所能提供的最大路径选择。即到当前节点后，选择下一步的节点的时候选择两个子节点中贡献值大的那个节点，来保证路径最大。
     *
     * 下面进行分析：就用官方题解这个二叉树来举例说明。
     *
     * ------------------------------------------------------
     * 我的理解
     * 路径，可以理解为指向，根据LeeCode的用例，每个节点都是往下一层指向两个节点，如果想把这个路径传递得尽可能长，只有可能根据箭头的方向，左右各找到一个点。
     *
     * 从思路上面来讲这题肯定是要遍历的。
     *
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    int maxSum = Integer.MIN_VALUE;

    /**
     * 本质上是后序遍历。
     *
     * 要讨论四种情况 四种情况分别是
     *
     * 单个数字最大值，
     * left + cur最大，
     * cur + right最大，
     * left + right + cur最大，
     * 四种
     *
     * 一，二，三这几种情况都可以作为树的一个子树再计算，但第四种是不能作为一个子树再计算的
     * @param node
     * @return
     */
    public int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int priceNewpath = node.val + leftGain + rightGain;

        // 更新答案
        maxSum = Math.max(maxSum, priceNewpath);

        // 返回节点的最大贡献值
        return node.val + Math.max(leftGain, rightGain);
    }
    /**
     * 这题得递归手法是之前见过的，通过引入第三个变量来完成递归的输出。
     * 在这个递归的过程中，原函数仅仅用来返回结果，递归另外起了一个函数，然后在这个另外起的函数里面进行递归
     * 返回的值回到上面的left/right Gain里面继续参加下面的计算。
     **/
}