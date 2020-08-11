package com.hugh.datastructure.linkedlist.mylinkedlist.myleecode.intersection;

import com.hugh.datastructure.linkedlist.mylinkedlist.utils.LinkedListUtils;
import com.hugh.datastructure.linkedlist.mylinkedlist.MySingleLinkedList;
import com.hugh.datastructure.linkedlist.mylinkedlist.Node;
import com.hugh.datastructure.linkedlist.mylinkedlist.pojo.Person;

/**
 * @program: draft
 * @description: 两个链表的交点
 * @author: Fly.Hugh
 * @create: 2020-07-24 21:04
 **/
public class Intersection {
    public static void main(String[] args) {

        Person intel = new Person("intel");
        Person apple = new Person("apple");
        Person amd = new Person("AMD");

        MySingleLinkedList listA = LinkedListUtils.generateSingleLinkList(intel, apple, amd);
        MySingleLinkedList listB = LinkedListUtils.generateSingleLinkList(intel, apple, amd);
        MySingleLinkedList listC = LinkedListUtils.generateSingleLinkList(intel, apple, amd);

        boolean b1 = judgeIfTheIntersectionExists(listA.getFirst());
        System.out.println(b1);

        /**
         * combine listA with c , B with C
         */
        listA.getLast().setNext(listC.getFirst());
        listB.getLast().setNext(listC.getFirst());

        Node intersectionNode = getIntersectionNode(listA.getFirst(), listB.getFirst());

        listA.getLast().setNext(listB.getFirst());

        boolean b = judgeIfTheIntersectionExists(listB.getFirst());
        System.out.println(b);


    }

    private static Node getIntersectionNode(Node headA, Node headB) {
        Node l1 = headA, l2 = headB;

        while (l1 != l2) {
            l1 = (l1 == null) ? headB : l1.getNext();
            l2 = (l2 == null) ? headA : l2.getNext();
        }
        return l1;
    }

    /*
        不够优雅
        public static boolean judgeIfTheIntersectionExists(Node head){

            boolean flag = true;

            if (head == null || head.getNext() == null) {
                flag = false;
            }

            Node slow = head.getNext();
            Node fast = head.getNext().getNext();

            while (slow != fast) {
                try {
                    slow = slow.getNext();
                    fast = fast.getNext().getNext();
                } catch (NullPointerException e) {
                    flag = false;
                }


                if(fast == null || slow == null){
                    flag = false;
                }
            }

            return flag;
        }*/
    public static boolean judgeIfTheIntersectionExists(Node head) {

        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.getNext() != null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();

            if(slow == fast) return true;
        }

        return false;
    }

}
