package com.hugh.datastructure.binarytree.leecode;

import com.hugh.datastructure.binarytree.utils.TreeNode;
import com.hugh.datastructure.binarytree.utils.TreeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author Fly.Hugh
 * @Date 2020/8/20 10:07
 * @Version 1.0
 **/
public class AverageOfLevelsInBinaryTree {
    public static void main(String[] args) {
        TreeNode root = TreeUtils.generateTreeFromArray(1, 2, 3, 4, 5, 6, 7);

    }

    /**
     * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
     *
     * 示例 1：
     *
     * 输入：
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 输出：[3, 14.5, 11]
     * 解释：
     * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
     *
     * 提示：
     *
     * 节点值的范围在32位有符号整数范围内。
     *
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Double> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> myQueue = new LinkedList<>();
        myQueue.add(root);
        while (!myQueue.isEmpty()) {
            int cnt = myQueue.size();
            double sum = 0;
            for (int i = 0; i < cnt; i++) {
                TreeNode poll = myQueue.poll();
                sum += poll.val;
                if (poll.left != null) {
                    myQueue.add(poll.left);
                }
                if (poll.right != null) {
                    myQueue.add(poll.right);
                }
            }
            ret.add(sum / cnt);
        }

        return ret;
    }

    public static void broadFirstSearch(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> myQueue = new LinkedList<>();
        myQueue.add(root);
        while (!myQueue.isEmpty()) {
            TreeNode poll = myQueue.poll();
            System.out.print(poll.val + " ");
            if (poll.left != null) {
                myQueue.add(poll.left);
            }
            if (poll.right != null) {
                myQueue.add(poll.right);
            }
        }
    }
}
