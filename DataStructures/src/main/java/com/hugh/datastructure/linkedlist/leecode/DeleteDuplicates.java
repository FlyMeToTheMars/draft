package com.hugh.datastructure.linkedlist.leecode;

import com.hugh.datastructure.LinkedListUtils;
import com.hugh.datastructure.linkedlist.MySingleLinkedList;
import com.hugh.datastructure.linkedlist.Node;

/**
 * @Author Fly.Hugh
 * @Date 2020/7/27 7:16 下午
 * @Version 1.0
 **/
public class DeleteDuplicates {
    public static void main(String[] args) {
        MySingleLinkedList listA = LinkedListUtils.generateSingleLinkList(1, 1, 2);
        Node node = deleteDuplicates(listA.getFirst());
        System.out.println(node.getElem());
        LinkedListUtils.traverseLinkListFromFirst(node);
        System.out.println(listA);

    }

    private static Node deleteDuplicates(Node<Integer> head) {
        if (head.getNext() == null) return head;
        if (head.getElem() == head.getNext().getElem()) {
            head.setNext(head.getNext().getNext());
            head = deleteDuplicates(head);
            return head;
        } else {
            head = deleteDuplicates(head.getNext());
            return head;
        }
    }
}
