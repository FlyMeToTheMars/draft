package com.hugh.datastructure.linkedlist.leecode.intersection;

import com.hugh.datastructure.linkedlist.MySingleLinkedList;
import com.hugh.datastructure.linkedlist.Node;



/**
 * @program: draft
 * @description: 测试
 * @author: Fly.Hugh
 * @create: 2020-07-24 23:40
 **/
public class IntersectionNewString {

    public static void main(String[] args) {
        MySingleLinkedList<String> clist = new MySingleLinkedList<String>();
        clist.addLast(new String("windows98"));
        clist.addLast(new String("windows99"));
        clist.addLast(new String("windows2000"));
        clist.addLast(new String("linux"));
        clist.addLast(new String("macOS"));
        clist.addLast(new String("ubuntu"));
        System.out.println("--------clist---------");
        System.out.println(clist);

        MySingleLinkedList<String> dlist = new MySingleLinkedList<String>();
        dlist.addLast(new String("windows91"));
        dlist.addLast(new String("windows92"));
        dlist.addLast(new String("windows93"));
        dlist.addLast(new String("linux"));
        dlist.addLast(new String("macOS"));
        dlist.addLast(new String("ubuntu"));
        System.out.println("--------dlist---------");
        System.out.println(dlist);

        System.out.println("----------getIntersectionNode-----------");

        System.out.println("----------intersectionNodeNEWString-----------");
        Node intersectionNode = getIntersectionNode(clist.getFirst(), dlist.getFirst());
        System.out.println(intersectionNode.getElem());
    }

    private static Node getIntersectionNode(Node<String> headA, Node<String> headB) {
        Node<String> l1 = headA, l2 = headB;
        System.out.println(l1.getElem());

        while ( l1.getElem() != l2.getElem()) {
            l1 = (l1 == null) ? headB : l1.getNext();
            l2 = (l2 == null) ? headA : l2.getNext();
        }
        return l1;
    }
}
