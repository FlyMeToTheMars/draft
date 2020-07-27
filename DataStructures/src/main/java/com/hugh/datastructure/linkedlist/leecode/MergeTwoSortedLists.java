package com.hugh.datastructure.linkedlist.leecode;

import com.hugh.datastructure.LinkedListUtils;
import com.hugh.datastructure.linkedlist.MySingleLinkedList;
import com.hugh.datastructure.linkedlist.Node;
import com.hugh.datastructure.linkedlist.SingleLinkedList;

/**
 * @Author Fly.Hugh
 * @Date 2020/7/27 5:40 下午
 * @Version 1.0
 **/
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        MySingleLinkedList<Integer> listA = LinkedListUtils.generateSingleLinkList(2, 4, 6, 7, 10, 13, 15, 17, 20);
        MySingleLinkedList<Integer> listB = LinkedListUtils.generateSingleLinkList(1, 3, 5, 7, 100);
        Node node = mergeTwoLists(listA.getFirst(), listB.getFirst());
        while (node != null) {
            System.out.println(node.getElem());
            node = node.getNext();
        }

    }

    /**
     * 归并两个有序的链表，
     * 继续使用递归的方法，非常优雅的代码
     * 要适应使用递归的方法，就要适应一个自下而上的思维。
     * 此情况下，通过递归先找到最大的值，然后每次回溯上一个节点的时候都有两个选项，所以代码最终变成了这个样子
     */
    private static Node mergeTwoLists(Node<Integer> l1, Node<Integer> l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.getElem() <= l2.getElem()) {
            l1.setNext(mergeTwoLists(l1.getNext(),l2));
            return l1;
        } else {
            l2.setNext(mergeTwoLists(l1,l2.getNext()));
            return l2;
        }
    }
}
