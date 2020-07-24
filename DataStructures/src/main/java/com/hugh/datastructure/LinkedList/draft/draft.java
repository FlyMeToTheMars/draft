package com.hugh.datastructure.LinkedList.draft;

import com.hugh.datastructure.LinkedList.Node;
import com.hugh.datastructure.LinkedList.pojo.Person;

/**
 * @program: draft
 * @description: draft
 * @author: Fly.Hugh
 * @create: 2020-07-24 23:49
 **/
public class draft {
    public static void main(String[] args) {
        Node node01 = new Node();
        node01.setElem("String");

        Node node02 = new Node();
        node02.setElem("String");

        System.out.println(node01 == node02);
        System.out.println(node01.getElem() == node02.getElem());
        System.out.println(node01.equals(node02));
        System.out.println(node01.getElem().equals(node02.getElem()));

        Node node03 = new Node();
        node03.setElem(new Person("String"));

        Node node04 = new Node();
        node04.setElem(new Person("String"));

        System.out.println(node03 == node04);
        System.out.println(node03.getElem() == node04.getElem());
        System.out.println(node03.equals(node04));
        System.out.println(node03.getElem().equals(node04.getElem()));



    }
}
