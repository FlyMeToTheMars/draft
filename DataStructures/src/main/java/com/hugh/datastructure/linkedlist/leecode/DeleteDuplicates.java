package com.hugh.datastructure.linkedlist.leecode;

import com.hugh.datastructure.LinkedListUtils;
import com.hugh.datastructure.linkedlist.MySingleLinkedList;
import com.hugh.datastructure.linkedlist.Node;

/**
 * @Author Fly.Hugh
 * @Date 2020/7/27 7:16 下午
 * @Desc 在有序链表中删除重复节点
 * @Version 1.0
 **/
public class DeleteDuplicates {
    public static void main(String[] args) {
        MySingleLinkedList listA = LinkedListUtils.generateSingleLinkList(1, 1, 2, 3, 3, 3, 3, 5);
        System.out.println(listA);
        Node node = deleteDuplicatesThird(listA.getFirst());
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

    private static Node deleteDuplicatesAnother(Node<Integer> head) {
        if (head == null || head.getNext() == null) return head;

        if (head.getElem() == head.getNext().getElem()) {
            head.setNext(deleteDuplicatesAnother(head.getNext()));
            return head;
        } else {
            head.setNext(deleteDuplicatesAnother(head.getNext()));
            return head.getNext();
        }
    }

    private static Node<Integer> deleteDuplicatesThird(Node<Integer> head) {
        if (head == null || head.getNext() == null) return head;

        head.setNext(deleteDuplicatesThird(head.getNext()));

        /**
        * @author Fly.Hugh
        * @Description 根据递归三问
         * 第一问 终止条件是什么
         * 第二问 本级递归需要做什么
         * 第三问 返回值是什么
         * 本题目中，根据递归三问，追溯到链表的最后，首先拿到了最后一个值
         * 这个值跟前面一个值进行对比，如果相等话，应该返还哪一个呢？
         * 肯定是返回后面一个的。
         * 原因是我们设置的返回值同时设置了前面一个链表的next
         * 如果我们返回第一个的话，等同于没有进行去重操作。
         * 如果返回第二个的话等于把倒数第三个的next设置在了最后一个上面。
         * 这样才是符合逻辑的。
        * @Date 4:17 2020/7/31
        * @Param [head]
        * @return com.hugh.datastructure.linkedlist.Node<java.lang.Integer>
        **/
        return (head.getElem() == head.getNext().getElem()) ? head.getNext() : head;
    }
}
