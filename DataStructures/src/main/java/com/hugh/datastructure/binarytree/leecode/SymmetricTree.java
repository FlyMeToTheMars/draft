package com.hugh.datastructure.binarytree.leecode;

import com.hugh.datastructure.binarytree.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: draft
 * @description: 对称树
 * @author: Fly.Hugh
 * @create: 2020-08-15 03:47
 **/
public class SymmetricTree {
    public static void main(String[] args) {

    }

    /**
    * @author Fly.Hugh
    * @Description
     * 给定一个二叉树，检查它是否是镜像对称的。
     *
     *
     * 例如，二叉树[1,2,2,3,4,4,3] 是对称的。
     *
     *     1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     *
     *
     * 但是下面这个[1,2,2,null,3,null,3] 则不是镜像对称的:
     *
     *     1
     *    / \
     *   2   2
     *    \   \
     *    3    3
     *
     * 进阶：
     *
     * 你可以运用递归和迭代两种方法解决这个问题吗？
     *
     * 先说递归，其实这题又转换成了LeeCode 100题的变种。100题是两棵树是否相等，这题是两颗树是否对称。
     *
    * @Date 3:48 2020/8/15
    * @Param [root]
    * @return boolean
    **/
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        return isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
    }

    //==================================================迭代>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    public boolean isSymmetricIter(TreeNode root) {
        return check(root, root);
    }

    /**
    * @author Fly.Hugh
    * @Description
     * 我们引入一个队列，这是把递归程序改写成迭代程序的常用方法。
     * 初始化时我们把根节点入队两次。每次提取两个结点并比较它们的值（队列中每两个连续的结点应该是相等的，而且它们的子树互为镜像），
     * 然后将两个结点的左右子结点按相反的顺序插入队列中。
     * 当队列为空时，或者我们检测到树不对称（即从队列中取出两个不相等的连续结点）时，该算法结束。
    * @Date 4:13 2020/8/15
    * @Param [u, v]
    * @return boolean
    **/
    public boolean check(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }
}
