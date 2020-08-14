package com.hugh.datastructure.binarytree.leecode;

import com.hugh.datastructure.binarytree.utils.TreeNode;

/**
 * @program: draft
 * @description: 统计路径和等于一个数的路径数量
 * @author: Fly.Hugh
 * @create: 2020-08-15 01:39
 **/
public class PathSumIII {
    public static void main(String[] args) {

    }

    /**
    * @author Fly.Hugh
    * @Description
     * 给定一个二叉树，它的每个结点都存放着一个整数值。
     * 找出路径和等于给定数值的路径总数。
     * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
     * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
     *
     * 示例：
     * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
     *
     *       10
     *      /  \
     *     5   -3
     *    / \    \
     *   3   2   11
     *  / \   \
     * 3  -2   1
     *
     * 返回 3。和等于 8 的路径有:
     *
     * 1.  5 -> 3
     * 2.  5 -> 2 -> 1
     * 3.  -3 -> 11
     *
     * 这道题目要和前面一题结合起来看，（PathSum）
     *
    * @Date 1:41 2020/8/15
    * @Param [root, sum]
    * @return int
    **/
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        int ret = 0;
        // 这里的用法十分巧妙，并没有全部递归下去，如果全部递归下去的则没有意义，递归，不要纠结在头脑风暴上
        // 这里左右节点都是用的是无限递归，但是头节点仅仅递归了一次，总的来说还是在套用那个模板，这里的头节点，仅仅是计算整个树的头节点符合要求的个数。
        ret = pathSumStartWithRoot(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        return ret;
    }

    private int pathSumStartWithRoot(TreeNode root, int sum) {
        if (root == null) return 0;
        int ret = 0;
        // 这里的判断条件十分重要，联想到之前的一直查找到跟节点的那个条件，那里是 left == null && right == null && sum = root.val ，和这里的区别就是不一定要到根节点，这里只要满足连续的条件即可
        if (sum == root.val) ret++;
        ret += pathSumStartWithRoot(root.left, sum - root.val) + pathSumStartWithRoot(root.right, sum - root.val);
        return  ret;
    }
    /**
    * @author Fly.Hugh
    * @Description 整道题目使用了两次递归，第一次递归，套用模板，深度遍历，第二个递归，其实仍然在求和的模板之内。
    * @Date 2:41 2020/8/15
    **/
}
