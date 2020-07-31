package com.hugh.datastructure.linkedlist.leecode;

import com.hugh.datastructure.LinkedListUtils;
import com.hugh.datastructure.dllist.MyDoubleLinkedList;
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
        System.out.println(node.getElem());
        System.out.println(listA);
    }

    private static Node<Integer> removeNthNodeFromEndOfList(Node<Integer> head, int n) {
        //双指针
        Node<Integer> slow = head;
        Node<Integer> fast = head;

        for (int i = 0; i < n; i++) {
            fast = fast.getNext();
        }

        while(fast != null && fast.getNext() != null) {
            fast = fast.getNext();
            slow = slow.getNext();
        }

        if(fast == null){

        } else {
            slow.setNext(slow.getNext().getNext());
        }

        return  head;
    }
}
