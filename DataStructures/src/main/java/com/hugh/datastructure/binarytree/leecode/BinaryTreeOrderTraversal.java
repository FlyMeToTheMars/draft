package com.hugh.datastructure.binarytree.leecode;

import com.hugh.datastructure.binarytree.utils.TreeNode;

import java.util.*;

/**
 * @program: draft
 * @description: 非递归实现前中后序遍历
 * @author: Fly.Hugh
 * @create: 2020-08-21 05:45
 **/
public class BinaryTreeOrderTraversal {
    public static void main(String[] args) {

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (pop == null) continue;
            ret.add(pop.val);
            stack.push(pop.right);
            stack.push(pop.left);
        }
        return ret;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) return ret;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            ret.add(node.val);
            cur = node.right;
        }
        return ret;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (pop == null) continue;
            ret.add(pop.val);
            stack.push(pop.left);
            stack.push(pop.right);
        }
        Collections.reverse(ret);
        return ret;
    }


}
