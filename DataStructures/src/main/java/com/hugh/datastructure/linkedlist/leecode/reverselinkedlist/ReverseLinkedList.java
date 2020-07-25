package com.hugh.datastructure.linkedlist.leecode.reverselinkedlist;

import com.hugh.datastructure.LinkedListUtils;
import com.hugh.datastructure.linkedlist.MySingleLinkedList;
import com.hugh.datastructure.linkedlist.Node;
import com.hugh.datastructure.linkedlist.pojo.Person;

/**
 * @Author Fly.Hugh
 * @Date 2020/7/25 17:53
 * @Version 1.0
 **/
public class ReverseLinkedList {
    public static void main(String[] args) {

        MySingleLinkedList list = LinkedListUtils.generateSingleLinkList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        reverseList(list.getFirst());
        System.out.println(list);
    }

    public static Node reverseList(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        Node next = head.getNext();
        Node newhead = reverseList(next);
        next.setNext(head);
        head.setNext(null);

        return newhead;
    }
}
