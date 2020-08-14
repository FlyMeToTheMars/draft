package com.hugh.datastructure.binarytree.leecode;

import com.hugh.datastructure.binarytree.utils.TreeNode;

/**
 * @program: draft
 * @description: 子树
 * @author: Fly.Hugh
 * @create: 2020-08-15 02:48
 **/
public class SubtreeOfAnotherTree {
    public static void main(String[] args) {

    }

    /**
    * @author Fly.Hugh
    * @Description
     *
     * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
     *
     * 示例 1:
     * 给定的树 s:
     *
     *      3
     *     / \
     *    4   5
     *   / \
     *  1   2
     * 给定的树 t：
     *
     *    4
     *   / \
     *  1   2
     * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
     *
     * 示例 2:
     * 给定的树 s：
     *
     *      3
     *     / \
     *    4   5
     *   / \
     *  1   2
     *     /
     *    0
     * 给定的树 t：
     *
     *    4
     *   / \
     *  1   2
     * 返回 false。
     *
     * 看到题目描述，首先判断一个树是否是另一棵树的子树，很明显想到可以用递归，但是两棵树完全相同也可以看做一棵树是另一棵树的子树。
     * 所以自然而然想到用一个判断两棵树是否相同的递归函数。
     *
     * 第一个递归和 PathSumIII 第一个递归的思想相同
     * 第二个递归则完完全全是 单独的问题，两树是否相同。 也就是LeeCode 100.题
     *
     *
    * @Date 2:49 2020/8/15
    * @Param [s, t]
    * @return boolean
    **/
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;

        return isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    /**
    * @author Fly.Hugh
    * @Description 这边 isSameTree的判断可以简化，要注意为什么可以这么写。
     *     if (t == null && s == null) return true;
     *     if (t == null || s == null) return false;
     *     if (t.val != s.val) return false;
     *     return isSubtreeWithRoot(s.left, t.left) && isSubtreeWithRoot(s.right, t.right);
     *
     *     可以写成这样，要考虑到满足上一个条件之后就已经直接return出去了，不会参与下面的村循环，这种情况下其实和if else的语法是一样的。
    * @Date 3:41 2020/8/15
    **/
}
