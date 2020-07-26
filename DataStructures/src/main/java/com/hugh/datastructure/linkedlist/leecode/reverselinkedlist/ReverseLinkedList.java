package com.hugh.datastructure.linkedlist.leecode.reverselinkedlist;

import com.hugh.datastructure.LinkedListUtils;
import com.hugh.datastructure.dllist.DLNode;
import com.hugh.datastructure.dllist.MyDoubleLinkedList;
import com.hugh.datastructure.linkedlist.MySingleLinkedList;
import com.hugh.datastructure.linkedlist.Node;
import com.hugh.datastructure.linkedlist.pojo.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @Author Fly.Hugh
 * @Date 2020/7/25 17:53
 * @Version 1.0
 **/
public class ReverseLinkedList {
    private static Logger logger = LogManager.getLogger(ReverseLinkedList.class.getName());

    public static void main(String[] args) {

        MySingleLinkedList list = LinkedListUtils.generateSingleLinkList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        reverseList(list.getFirst());

        System.out.println(list);
    }

    /**
    * @author Fly.Hugh
    * @Description 递归反转列表 head -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9
    *                   变为  head -> 1 <- 2 <- 3 <- 4 <- 5 <- 6 <- 7 <- 8 <- 9  可以因为我的链表设计了null的head 所以导致了反转之后使用原先输出方式就不正确了
    * @Date 16:35 2020/7/26
    * @Param [head]
    * @return com.hugh.datastructure.linkedlist.Node
    **/
    public static Node reverseList(Node head) {
        logger.info("step1:" + head + " " + head.getElem());
        if (head == null || head.getNext() == null || head.getNext().getElem() == null) {
            return head;
        }

        Node next = head.getNext();
        Node newhead = reverseList(next);

        next.setNext(head);
        head.setNext(null);

        return newhead;
    }

    public static DLNode reverseDoubleList(DLNode head) {
        logger.info("step1:" + head + " " + head.getElem());
        if (head == null || head.getNext() == null) {
            return head;
        }

        DLNode next = head.getNext();
        DLNode newhead = reverseDoubleList(next);

        next.setNext(head);
        head.setNext(null);

        return newhead;
    }
}
