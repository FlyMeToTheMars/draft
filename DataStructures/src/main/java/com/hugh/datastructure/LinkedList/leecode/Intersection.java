package com.hugh.datastructure.LinkedList.leecode;

import com.hugh.datastructure.LinkedList.MySingleLinkedList;
import com.hugh.datastructure.LinkedList.Node;
import com.hugh.datastructure.LinkedList.SingleLinkedList;
import com.hugh.datastructure.LinkedList.pojo.Person;

/**
 * @program: draft
 * @description: 两个链表的交点
 * @author: Fly.Hugh
 * @create: 2020-07-24 21:04
 **/
public class Intersection {
    public static void main(String[] args) {

        MySingleLinkedList<String> alist = new MySingleLinkedList<String>();

        alist.addLast("windows98");
        alist.addLast("windows99");
        alist.addLast("windows2000");
        alist.addLast("linux");
        alist.addLast("macOS");
        alist.addLast("ubuntu");
        System.out.println("--------alist---------");
        System.out.println(alist);

        MySingleLinkedList<String> blist = new MySingleLinkedList<String>();
        blist.addLast("windows91");
        blist.addLast("windows92");
        blist.addLast("windows93");
        blist.addLast("linux");
        blist.addLast("macOS");
        blist.addLast("ubuntu");
        System.out.println("--------blist---------");
        System.out.println(blist);

        System.out.println("----------intersectionNodeString-----------");
        Node intersectionNodeString = getIntersectionNode(alist.getFirst(), blist.getFirst());
        System.out.println(intersectionNodeString.getElem());



/*        String a = new String("123");
        String b = new String("123");

        String a1 = "123";
        String b1 = "123";
        System.out.println(a == b);
        System.out.println(a1 == b1);*/


    }

    /*    private static Node getIntersectionNode(Node headA, Node headB) {
            Node l1 = headA, l2 = headB;

            while ( l1 != l2) {
                l1 = (l1 == null) ? headB : l1.getNext();
                l2 = (l2 == null) ? headA : l2.getNext();
            }
            return l1;
        }*/
    private static Node getIntersectionNode(Node headA, Node headB) {
        Node l1 = headA, l2 = headB;

        while (l1.getElem() != l2.getElem()) {
            l1 = (l1 == null) ? headB : l1.getNext();
            l2 = (l2 == null) ? headA : l2.getNext();
        }
        return l1;
    }
}
