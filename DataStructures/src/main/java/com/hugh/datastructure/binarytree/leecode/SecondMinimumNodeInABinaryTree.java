package com.hugh.datastructure.binarytree.leecode;

import com.hugh.datastructure.binarytree.utils.TreeNode;

/**
 * @program: draft
 * @description: 找出二叉树中第二小的节点
 * @author: Fly.Hugh
 * @create: 2020-08-15 18:11
 **/
public class SecondMinimumNodeInABinaryTree {
    public static void main(String[] args) {

    }

    /**
    * @author Fly.Hugh
    * @Description
     * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
     *
     * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
     *
     * 示例 1:
     *
     * 输入:
     *     2
     *    / \
     *   2   5
     *      / \
     *     5   7
     *
     * 输出: 5
     * 说明: 最小的值是 2 ，第二小的值是 5 。
     * 示例 2:
     *
     * 输入:
     *     2
     *    / \
     *   2   2
     *
     * 输出: -1
     * 说明: 最小的值是 2, 但是不存在第二小的值。
     *
    * @Date 18:12 2020/8/15
    * @Param [root]
    * @return int
    **/
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        if (root.left == null && root.right == null) return -1;
        int leftValue = root.left.val;
        int rightValue = root.right.val;
        // 巧妙，太牛了，几个点，首先这种写法从上到下都简化了if else的else，其次这里的判断条件结合题意：每个子树的头节点总是后面最小的值，这里的值不是root，没必要再找了，就是这个最小了。在后面return.
        if (leftValue == root.val) leftValue = findSecondMinimumValue(root.left);
        if (rightValue == root.val) rightValue = findSecondMinimumValue(root.right);
        if (leftValue != -1 && rightValue != -1) return Math.min(leftValue, rightValue);
        if (leftValue == -1) return rightValue;
        return leftValue;
    }
}
