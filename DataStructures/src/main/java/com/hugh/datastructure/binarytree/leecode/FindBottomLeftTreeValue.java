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

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> myQueue = new LinkedList<>();
        myQueue.add(root);
        while (!myQueue.isEmpty()) {
            root = myQueue.poll();

            // 顺序很重要
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
