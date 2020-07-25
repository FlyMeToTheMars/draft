package com.hugh.datastructure.linkedlist.leecode.intersection;

import com.hugh.datastructure.linkedlist.MySingleLinkedList;
import com.hugh.datastructure.linkedlist.Node;
import com.hugh.datastructure.linkedlist.pojo.Person;

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

//        flist.addLast(new Person("windows98"));
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
        Person NULL = new Person("NULL");
        Node<Person> l3 = new Node<Person>(NULL,headA);

        while (!(l1.getElem().equals(l2.getElem()))) {

            l1 = (l1 == l3) ? headB : l1.getNext();
            if (l1 == null) l1 = l3;

            l2 = (l2 == null) ? headA : l2.getNext();
            if (l2 == null) l2 = l3;
        }

        return l1;
    }

}
