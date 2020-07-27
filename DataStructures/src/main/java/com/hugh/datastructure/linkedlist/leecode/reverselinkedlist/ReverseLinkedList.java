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

        System.out.println(list);

        Node node = reverseIterativeltly(list.getFirst());

        while (node != null) {
            System.out.println(node.getElem());
            node = node.getNext();
        }
    }

    /**
     * 
     * @return com.hugh.datastructure.linkedlist.Node
     * @author Fly.Hugh
     * @Description 递归反转列表 head -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9
     * 变为  head -> 1 <- 2 <- 3 <- 4 <- 5 <- 6 <- 7 <- 8 <- 9  可以因为我的链表设计了null的head 所以导致了反转之后使用原先输出方式就不正确了
     * @Date 16:35 2020/7/26
     * @Param [head]
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

    /**
     * 头插法，
     * 从第一个值开始改变，有三个指针，pre指针，next指针，head也就是cur指针，每次循环改变pre和next的值，
     * pre 和 next 分别记录上一个迭代和下一个迭代head的值
     * @param head
     * @return
     */
    public static Node reverseIterativeltly(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            /**
             * 1.为next赋值
             */
            next = head.getNext();
            /**
             * 2.pre指针每次使用的值都是延迟一个迭代，所以先使用再赋值
             */
            head.setNext(pre);
            /**
             * 3.为pre赋新值进入下一个轮回
             */
            pre = head;
            /**
             * 4.head指针重新赋值
             */
            head = next;
        }
        return pre;
    }
}
