package com.hugh.datastructure;

import com.hugh.datastructure.dllist.DoubleLinkedList;

/**
 * @program: draft
 * @description: 链表测试
 * @author: Fly.Hugh
 * @create: 2020-07-22 23:50
 **/
public class LinkedListTest {
    public static void main(String[] args) {

        System.out.println("[INFO]: Test DoubleLinkedList() ...");

        DoubleLinkedList<String> aList = new DoubleLinkedList<String>();

        for (int i = 0; i < 10; ++i) {
            aList.addLast(String.valueOf(i));
        }
        /**
        * @author Fly.Hugh
        * @Description [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, ]
        * @Date 1:59 2020/7/24
        * @Param [args]
        * @return void
        **/
        System.out.println(aList);
        
        /**
        * @author Fly.Hugh
        * @Description aList.size(): 10
        * @Date 1:59 2020/7/24
        * @Param [args]
        * @return void
        **/
        System.out.println(
                "aList.size(): " +
                        aList.size()
        );

        System.out.println(
                "aList.contains(\"2\"): " +
                        aList.contains("2")
        );

        System.out.println(
                "aList.contains(\"10\"): " +
                        aList.contains("10")
        );

        System.out.println(
                "aList.addFirst(\"Java\")"
        );

        System.out.println(
                "aList.addLast(\"Python\")"
        );

        aList.addFirst("Java");

        aList.addLast("Python");

        System.out.println(aList);

        System.out.println(
                "aList.remove(1): " +
                        aList.remove(1)
        );

        System.out.println(aList);

        System.out.println(
                "aList.remove(\"8\"): " +
                        aList.remove("8")
        );

        System.out.println(aList);

        System.out.println(
                "aList.get(0): " +
                        aList.get(0)
        );

        System.out.println(
                "aList.set(1, \"JavaScript\"): " +
                        aList.set(1, "JavaScript")
        );

        System.out.println(aList);

        System.out.println(
                "aList.indexOf(\"Python\"): " +
                        aList.indexOf("Python")
        );

        System.out.println(
                "aList.indexOf(\"C++\"): " +
                        aList.indexOf("C++")
        );

        System.out.println(
                "aList.insert(1, \"Golang\"): " +
                        aList.insert(1, "Golang")
        );

        System.out.println(aList);

        System.out.println(
                "aList.clear()"
        );

        aList.clear();

        System.out.println(aList);
    }
}