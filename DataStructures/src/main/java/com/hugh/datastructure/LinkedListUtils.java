package com.hugh.datastructure;

import com.hugh.datastructure.linkedlist.MySingleLinkedList;
import com.hugh.datastructure.linkedlist.pojo.Person;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;

/**
 * @Author Fly.Hugh
 * @Date 2020/7/25 15:57
 * @Version 1.0
 **/
public class LinkedListUtils {

    private static Logger logger = LogManager.getLogger(LinkedListUtils.class.getName());

    public static void main(String[] args) {
        Person intel = new Person("intel");
        Person apple = new Person("apple");
        Person amd = new Person("AMD");
        MySingleLinkedList mySingleLinkedList = generateSingleLinkList(intel, apple, amd);
        System.out.println(mySingleLinkedList);
    }

    /**
     * 快速生成单向链表
     * @param objects
     * @return MySingleLinkedList
     */
    public static MySingleLinkedList generateSingleLinkList(Object... objects) {

        logger.info("链表生成中...");
        MySingleLinkedList mySingleLinkedList = new MySingleLinkedList();
        for (Object o : objects) {
            logger.info("链表"+mySingleLinkedList+"添加了新元素:" + o);
            mySingleLinkedList.addLast(o);
        }
        return mySingleLinkedList;
    }

}
