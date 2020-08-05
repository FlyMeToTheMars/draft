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
        MySingleLinkedList listA = LinkedListUtils.generateSingleLinkList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        MySingleLinkedList listB = LinkedListUtils.generateSingleLinkList(1,1,1,1,1,1);
        Node node = addTwoNumbersMedium(listA.getFirst(), listB.getFirst());
        LinkedListUtils.traverseLinkListFromFirst(node);
    }

    /**
     * 说实话 我只想用递归来做这题
     * 但是递归并没有很好地办法来解决这个问题。
     * 这个问题里面引入了Java6 开始使用的Stack，stack可以作为一个新的知识点存入我的leeocode框架。
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
        while(!s1.isEmpty() || !s2.isEmpty() || c > 0) {
            int sum = (s1.isEmpty() ? 0 : s1.pop()) + (s2.isEmpty() ? 0 : s2.pop()) + c;
            Node n = new Node(sum % 10, null);
            c = sum / 10;
            n.setNext(res);
            res = n;
        }

        return res;
    }
}
