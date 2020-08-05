package com.hugh.datastructure.linkedlist.leecode;

import com.hugh.datastructure.LinkedListUtils;
import com.hugh.datastructure.linkedlist.MySingleLinkedList;
import com.hugh.datastructure.linkedlist.Node;

import java.util.Stack;

/**
 * @Author Fly.Hugh
 * @Date 2020/8/5 15:29
 * @Version 1.0
 **/
public class AddTwoNumbers {
    public static void main(String[] args) {
        MySingleLinkedList listA = LinkedListUtils.generateSingleLinkList(3, 9, 2, 5);
        MySingleLinkedList listB = LinkedListUtils.generateSingleLinkList(4, 6, 2, 9);
//        Node node = addTwoNumbersMedium(listA.getFirst(), listB.getFirst());
        Node node = addTwoNumbersEasy(listA.getFirst(), listB.getFirst());
        LinkedListUtils.traverseLinkListFromFirst(node);
    }

    /**
     * 说实话 我只想用递归来做这题
     * 但是递归并没有很好地办法来解决这个问题。
     * 这个问题里面引入了Java6 开始使用的Stack，stack可以作为一个新的知识点存入我的leeocode框架。
     *
     * @param headA
     * @param headB
     * @return
     */
    private static Node addTwoNumbersMedium(Node<Integer> headA, Node<Integer> headB) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (headA != null) {
            s1.push(headA.getElem());
            headA = headA.getNext();
        }

        while (headB != null) {
            s2.push(headB.getElem());
            headB = headB.getNext();
        }

        Node res = null;
        int c = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || c > 0) {
            int sum = (s1.isEmpty() ? 0 : s1.pop()) + (s2.isEmpty() ? 0 : s2.pop()) + c;
            Node n = new Node(sum % 10, null);
            c = sum / 10;
            n.setNext(res);
            res = n;
        }

        return res;
    }

    /**
     * @return com.hugh.datastructure.linkedlist.Node
     * @author Fly.Hugh
     * @Description 这个情况要比上面的情况简单不少，少了一个过程，就是那个压栈 弹栈的过程。
     * @Date 21:37 2020/8/5
     * @Param [headA, headB]
     **/
    private static Node addTwoNumbersEasy(Node<Integer> headA, Node<Integer> headB) {
        Node nh = new Node(0, null);
        int c = 0;
        Node index = nh;

        while (headA != null || headB != null || c > 0) {
            int sum =
                    ((headA == null) ? 0 : headA.getElem()) +
                            ((headB == null) ? 0 : headB.getElem()) +
                            c;
            index.setNext(new Node(sum % 10, null));
            index = index.getNext();
            c = sum / 10;
            if (headA != null) headA = headA.getNext();
            if (headB != null) headB = headB.getNext();
        }
        if (c > 0) index.setNext(new Node(c, null));
        return nh.getNext();
    }
}
