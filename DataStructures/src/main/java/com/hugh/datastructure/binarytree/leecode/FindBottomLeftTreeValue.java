package com.hugh.datastructure.binarytree.leecode;

import com.hugh.datastructure.binarytree.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Fly.Hugh
 * @Date 2020/8/20 12:14
 * @Version 1.0
 **/
public class FindBottomLeftTreeValue {
    public static void main(String[] args) {

    }

    /**
     * 给定一个二叉树，在树的最后一行找到最左边的值。
     *
     * 示例 1:
     *
     * 输入:
     *
     *     2
     *    / \
     *   1   3
     *
     * 输出:
     * 1
     *
     * 示例 2:
     *
     * 输入:
     *
     *         1
     *        / \
     *       2   3
     *      /   / \
     *     4   5   6
     *        /
     *       7
     *
     * 输出:
     * 7
     *
     * 注意: 您可以假设树（即给定的根节点）不为 NULL。
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> myQueue = new LinkedList<>();
        myQueue.add(root);
        while (!myQueue.isEmpty()) {
            root = myQueue.poll();

            // 顺序很重要 如果是Left的就放在前面
            if (root.right != null) {
                myQueue.add(root.right);
            }

            if (root.left != null) {
                myQueue.add(root.left);
            }
        }
        return root.val;
    }
}
