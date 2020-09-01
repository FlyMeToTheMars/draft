package com.hugh.datastructure.binarytree.leecode;

import com.hugh.datastructure.binarytree.utils.TreeNode;

import java.util.HashSet;

/**
 * @Author Fly.Hugh
 * @Date 2020/9/1 11:43 上午
 * @Version 1.0
 **/
public class TwoSumIV {
    public static void main(String[] args) {

    }

    /**
     * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
     *
     * 案例 1:
     *
     * 输入: 
     *     5
     *    / \
     *   3   6
     *  / \   \
     * 2   4   7
     *
     * Target = 9
     *
     * 输出: True
     * 
     *
     * 案例 2:
     *
     * 输入: 
     *     5
     *    / \
     *   3   6
     *  / \   \
     * 2   4   7
     *
     * Target = 28
     *
     * 输出: False
     *
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return find(root, k, set);
    }

    private boolean find(TreeNode root, int k, HashSet<Integer> set) {
        if(root==null) return false;
        if(set.contains(k - root.val)) return true;
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
    }
}
