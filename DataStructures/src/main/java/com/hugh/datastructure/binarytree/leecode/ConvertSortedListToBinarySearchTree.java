package com.hugh.datastructure.binarytree.leecode;

import com.hugh.datastructure.binarytree.utils.TreeNode;
import com.hugh.datastructure.linkedlist.leecode.standardutils.ListNode;

/**
 * @program: draft
 * @description: 根据有序链表构造平衡的二叉查找树BST
 * @author: Fly.Hugh
 * @create: 2020-08-31 23:22
 **/
public class ConvertSortedListToBinarySearchTree {
    public static void main(String[] args) {

    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */

    /**
    * @author Fly.Hugh
    * @Description
     * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
     *
     * 本题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1。
     *
     * 示例:
     *
     * 给定的有序链表： [-10, -3, 0, 5, 9],
     *
     * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
     *
     *       0
     *      / \
     *    -3   9
     *    /   /
     *  -10  5
     *
    * @Date 23:26 2020/8/31
    * @Param [head]
    * @return com.hugh.datastructure.binarytree.utils.TreeNode
    **/
    public TreeNode sortedListToBST(ListNode head) {
        //边界条件的判断
        if(head==null) return null;
        // 如果不加这个边界条件判断，在后面得断开链表环节会出现NullException
        if(head.next==null) return new TreeNode(head.val);
        //这里通过快慢指针找到链表的中间结点slow，pre就是中间
        //结点slow的前一个结点
        ListNode slow = head, fast = head, pre = null;
        //链表断开为两部分，一部分是node的左子节点，一部分是node
        //的右子节点
        while(fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        //node就是当前节点
        TreeNode node = new TreeNode(slow.val);
        //从head节点到pre节点是node左子树的节点
        node.left = sortedListToBST(head);
        //从slow.next到链表的末尾是node的右子树的结点 从这里也可以看到引入pre的原因，slow和pre分开了，这里才能引用slow.next
        node.right = sortedListToBST(slow.next);
        return node;
    }
}
