package com.hugh.datastructure.linkedlist.leecode;

import com.hugh.datastructure.LinkedListUtils;
import com.hugh.datastructure.linkedlist.MySingleLinkedList;
import com.hugh.datastructure.linkedlist.Node;

/**
 * @program: draft
 * @description: 删除链表的倒数第N个节点
 * @author: Fly.Hugh
 * @create: 2020-07-31 05:01
 **/
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        MySingleLinkedList listA = LinkedListUtils.generateSingleLinkList(1);
        System.out.println(listA);
        Node node = removeNthNodeFromEndOfList(listA.getFirst(), 1);
        System.out.println(node);
    }

    /**
     * 汗颜，想起我做的第一道题目，求两链表交点的那题，当时那题，我引入了一个L3节点
     * 因为两个链表长度不一样的时候，先遍历完毕的那个链表会出现一个Null.getElement的空指针问题，
     * 我他妈研究了好久，引入了一个L3，因为没有总结，在这道题目用例是[1] 1的时候出现的空指针又卡了好久。
     * @param head
     * @param n
     * @return
     */
    private static Node<Integer> removeNthNodeFromEndOfList(Node<Integer> head, int n) {
        Node<Integer> pre = new Node<>();
        pre.setNext(head);
        //双指针
        Node<Integer> slow = pre;
        Node<Integer> fast = pre;

/*        for (int i = 0; i < n; i++) {
            fast = fast.getNext();
        }*/

        // 另一种写法
        while(n != 0){
            fast = fast.getNext();
            n--;
        }

        while(fast.getNext() != null) {
            fast = fast.getNext();
            slow = slow.getNext();
        }

        slow.setNext(slow.getNext().getNext());

        return  pre.getNext();
    }
}
