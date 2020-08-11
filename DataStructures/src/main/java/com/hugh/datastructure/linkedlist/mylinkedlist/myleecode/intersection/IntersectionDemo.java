package com.hugh.datastructure.linkedlist.mylinkedlist.myleecode.intersection;

import com.hugh.datastructure.linkedlist.mylinkedlist.MySingleLinkedList;
import com.hugh.datastructure.linkedlist.mylinkedlist.Node;
import com.hugh.datastructure.linkedlist.mylinkedlist.pojo.Person;

/**
 * @Author Fly.Hugh
 * @Date 2020/7/25 15:10
 * @Version 1.0
 **/
public class IntersectionDemo {
    public static void main(String[] args) {
        Person linux = new Person("Linux");
        Person macOS = new Person("macOS");
        Person ubuntu = new Person("Ubuntu");

        Person window91 = new Person("window91");
        Person window92 = new Person("window92");

        Person window93 = new Person("window93");
        Person window94 = new Person("window94");
        Person window95 = new Person("window95");

        MySingleLinkedList listA = new MySingleLinkedList();
        listA.addLast(window91);
        listA.addLast(window92);
        listA.addLast(linux);
        listA.addLast(macOS);
        listA.addLast(ubuntu);


        MySingleLinkedList listB = new MySingleLinkedList();
        listB.addLast(window93);
        listB.addLast(window94);
        listB.addLast(window95);
        listB.addLast(linux);
        listB.addLast(macOS);
        listB.addLast(ubuntu);



/*        listA.getLast().setNext(listB.getFirst());
        System.out.println(listA);*/

    }

    private static Node getIntersectionNode(Node headA, Node headB) {
        Node n1 = headA, n2 = headB;
        while (n1 != n2) {
            n1 = (n1 == null) ? headB : n1.getNext();
            n2 = (n2 == null) ? headA : n2.getNext();
        }
        return n1;
    }
}
