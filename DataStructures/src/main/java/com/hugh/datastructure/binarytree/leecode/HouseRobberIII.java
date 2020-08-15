package com.hugh.datastructure.binarytree.leecode;

import com.hugh.datastructure.binarytree.utils.TreeNode;

/**
 * @program: draft
 * @description: 间隔遍历
 * @author: Fly.Hugh
 * @create: 2020-08-15 16:23
 **/
public class HouseRobberIII {
    public static void main(String[] args) {

    }

    /**
    * @author Fly.Hugh
    * @Description
     * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
     *
     * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
     *
     * 示例 1:
     *
     * 输入: [3,2,3,null,3,null,1]
     *
     *      3
     *     / \
     *    2   3
     *     \   \
     *      3   1
     *
     * 输出: 7
     * 解释:小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
     * 示例 2:
     *
     * 输入: [3,4,5,1,3,null,1]
     *
     *      3
     *     / \
     *    4   5
     *   / \   \
     *  1   3   1
     *
     * 输出: 9
     * 解释:小偷一晚能够盗取的最高金额= 4 + 5 = 9.
     *
     * 这题我第一时间想复杂了，要注意题目，必须是从根节点开始取得。
     * 那么两情况分别是取根节点（就是本节点和间隔一层的两个节点*（前提条件是判断存不存在子节点））和不取根节点的情况（就是两个子节点）
     *
    * @Date 16:24 2020/8/15
    * @Param [root]
    * @return int
    **/
    public int rob(TreeNode root) {
        if (root == null) return 0;
        int singleSum = root.val;
        if (root.left != null) singleSum += rob(root.left.left) + rob(root.left.right);
        if (root.right!= null) singleSum += rob(root.right.left) + rob(root.right.right);
        int doubleSum = rob(root.left) + rob(root.right);
        return Math.max(doubleSum, singleSum);
    }
}
