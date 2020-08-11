package com.hugh.datastructure.linkedlist.mylinkedlist.myleecode;

import com.hugh.datastructure.linkedlist.mylinkedlist.utils.LinkedListUtils;
import com.hugh.datastructure.linkedlist.mylinkedlist.MySingleLinkedList;
import com.hugh.datastructure.linkedlist.mylinkedlist.Node;
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

        Node node = reverseList(list.getFirst());

        /**
         * 因为整个链表已经反转，所以只能根据新的头节点往下便利出新的节点。
         */
        while (node != null) {
            System.out.println(node.getElem());
            node = node.getNext();
        }
    }

    /**
     *
     * @return com.hugh.datastructure.linkedlist.mylinkedlist.Node
     * @author Fly.Hugh
     * @Description 递归反转列表 head -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9
     * 变为  head -> 1 <- 2 <- 3 <- 4 <- 5 <- 6 <- 7 <- 8 <- 9  可以因为我的链表设计了null的head 所以导致了反转之后使用原先输出方式就不正确了
     * @Date 16:35 2020/7/26
     * @Param [head]
     **/
    public static Node reverseList(Node head) {
        logger.info("step1:" + head + " " + head.getElem());
        if (head == null || head.getNext() == null) {
            return head;
        }

        Node next = head.getNext();
        Node newhead = reverseList(next);
        /**
         * 这里的 newhead 的赋值过程，在head = 9的时候，作为head Node类型返回
         * 返回是9之后，这个9在每一次递归的过程中都在传递，因为不涉及 newhead 元素的再次赋值，只是简单的值传递，
         * 所以一直到最后返回的都是9，也就是头节点。
         * */
        logger.info("newhead:" + newhead + " " + newhead.getElem());
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
