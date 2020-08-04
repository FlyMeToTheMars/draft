package com.hugh.datastructure.linkedlist.leecode;

import com.hugh.datastructure.LinkedListUtils;
import com.hugh.datastructure.linkedlist.MySingleLinkedList;
import com.hugh.datastructure.linkedlist.Node;

/**
 * @Author Fly.Hugh
 * @Date 2020/8/4 6:15 下午
 * @Version 1.0
 **/
public class SwapPairs {
    public static void main(String[] args) {
        MySingleLinkedList listA = LinkedListUtils.generateSingleLinkList(1, 2, 3, 4, 5, 6, 7, 8);
        System.out.println(listA);
        Node node = swapPairs(listA.getFirst());
        System.out.println(node);

        LinkedListUtils.traverseLinkListFromFirst(node);
    }

    private static Node swapPairs(Node head){
        Node odd = head;
        Node event = head.getNext();


        Node newhead = new Node();
        newhead.setNext(event);

        while (event != null && event.getNext() != null) {

            odd.setNext(event.getNext());
            event.setNext(odd);

            odd = odd.getNext();
            event = odd.getNext().getNext();
        }

        return newhead.getNext();
    }
}
