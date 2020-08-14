package com.hugh.datastructure.binarytree.utils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: draft
 * @description: 工具类
 * @author: Fly.Hugh
 * @create: 2020-08-12 06:10
 **/
public class TreeUtils {
    public static void main(String[] args) {
        TreeNode treeNode = generateTreeFromArray(1,2,3,4,5,6,7);
        TreeUtils.depthOrderTraverse(treeNode);
    }

    /**
    * @author Fly.Hugh
    * @Description 从LeeCode给出的数组还原出树
    * @Date 6:28 2020/8/12
    * @Param [nums]
    * @return com.hugh.datastructure.binarytree.utils.TreeNode
    **/
    public static TreeNode generateTreeFromArray(Integer... nums) {
        if (nums.length == 0) {
            return null;
        }
        TreeNode head = new TreeNode(nums[0]);
        // stack的本质是由linked list或者array实现的
        LinkedList<TreeNode> subTree = new LinkedList<>();
        subTree.push(head);
        for (int i = 1; i < nums.length; i++) {
            if (!subTree.isEmpty()) {
                TreeNode cur = subTree.pop();
                if (nums[i] != null) {
                    cur.left = new TreeNode(nums[i]);
                    subTree.add(cur.left);
                }
                i++;
                if (i >= nums.length) {
                    break;
                }
                if (nums[i] != null) {
                    cur.right = new TreeNode(nums[i]);
                    subTree.add(cur.right);
                }

            } else {
                break;
            }
        }
        return head;
    }

    /**
    * @author Fly.Hugh
    * @Description 前序遍历
    * @Date 6:26 2020/8/12
    * @Param [root]
    * @return void
    **/
    public static void preOrderTraverse(TreeNode root) {
        if (root != null) {
            System.out.print(root.val+"  ");
            preOrderTraverse(root.left);
            preOrderTraverse(root.right);
        }
    }

    /**
    * @author Fly.Hugh
    * @Description 中序遍历
    * @Date 6:27 2020/8/12
    * @Param [root]
    * @return void
    **/
    public static void inOrderTraverse(TreeNode root) {
        if (root != null) {
            inOrderTraverse(root.left);
            System.out.print(root.val+"  ");
            inOrderTraverse(root.right);
        }
    }

    /**
    * @author Fly.Hugh
    * @Description 后序遍历
    * @Date 6:27 2020/8/12
    * @Param [root]
    * @return void
    **/
    public static void postOrderTraverse(TreeNode root) {
        if (root != null) {
            postOrderTraverse(root.left);
            postOrderTraverse(root.right);
            System.out.print(root.val+"  ");
        }
    }

    /**
    * @author Fly.Hugh
    * @Description 层次遍历
    * @Date 6:27 2020/8/12
    * @Param [root]
    * @return void
    **/
    public static void levelTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val+"  ");
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    /**
    * @author Fly.Hugh
    * @Description 深度优先遍历
    * @Date 6:28 2020/8/12
    * @Param [root]
    * @return void
    **/
    public static void depthOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val+"  ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    /**
    * @author Fly.Hugh
    * @Description 广度优先遍历
    * @Date 6:36 2020/8/12
    * @Param [nodeHead]
    * @return void
    **/
    public static void broadFirstSearch(TreeNode nodeHead) {
        if(nodeHead==null) {
            return;
        }
        Queue<TreeNode> myQueue=new LinkedList<>();
        myQueue.add(nodeHead);
        while(!myQueue.isEmpty()) {
            TreeNode node=myQueue.poll();
            System.out.print(node.val+" ");
            if(null!=node.left) {
                myQueue.add(node.left);    //深度优先遍历，我们在这里采用每一行从左到右遍历
            }
            if(null!=node.right) {
                myQueue.add(node.right);
            }
        }
    }
}
