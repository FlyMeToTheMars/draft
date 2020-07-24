package com.hugh.datastructure.LinkedList.leecode;

import com.hugh.datastructure.LinkedList.MySingleLinkedList;
import com.hugh.datastructure.LinkedList.Node;
import com.hugh.datastructure.LinkedList.pojo.Person;

/**
 * @program: draft
 * @description: person
 * @author: Fly.Hugh
 * @create: 2020-07-24 23:43
 **/
public class IntersectionPerson {
    public static void main(String[] args) {

        MySingleLinkedList<Person> elist = new MySingleLinkedList<Person>();

        elist.addLast(new Person("windows91"));
        elist.addLast(new Person("windows92"));
        elist.addLast(new Person("windows93"));
        elist.addLast(new Person("linux"));
        elist.addLast(new Person("macOS"));
        elist.addLast(new Person("ubuntu"));
        System.out.println("--------elist---------");
        System.out.println(elist.toString());

        MySingleLinkedList<Person> flist = new MySingleLinkedList<Person>();

        flist.addLast(new Person("windows98"));
        flist.addLast(new Person("windows99"));
        flist.addLast(new Person("windows2000"));
        flist.addLast(new Person("linux"));
        flist.addLast(new Person("macOS"));
        flist.addLast(new Person("ubuntu"));
        System.out.println("--------flist---------");
        System.out.println(flist);

        Node intersectionNode = getIntersectionNode(elist.getFirst(), flist.getFirst());

        System.out.println(intersectionNode.getElem());
    }

    private static Node getIntersectionNode(Node<Person> headA, Node<Person> headB) {
        Node<Person> l1 = headA, l2 = headB;
//        System.out.println("l1:" + l1.getElem() + " l2:" + l2.getElem());

        while (!(l1.getElem().equals(l2.getElem()))) {

            System.out.println(l1 == null);
            l1 = (l1 == null) ? headB : l1.getNext();
//            System.out.println(l2 == null);
            l2 = (l2 == null) ? headA : l2.getNext();
//            System.out.println("l1:" + l1.getElem() + " l2:" + l2.getElem());
        }
//        System.out.println("l1:" + l1 + " l2:" + l2);
        return l1;
    }
}
