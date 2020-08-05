package com.hugh.datastructure.linkedlist.leecode;

import com.hugh.datastructure.LinkedListUtils;
import com.hugh.datastructure.linkedlist.MySingleLinkedList;
import com.hugh.datastructure.linkedlist.Node;

/**
 * @Author Fly.Hugh
 * @Date 2020/8/4 6:15 下午
 * @Version 1.0
 **/
public class SwapPairs {
    public static void main(String[] args) {
        MySingleLinkedList listA = LinkedListUtils.generateSingleLinkList(1,2,3,4,5,6,7,8,9);
        System.out.println(listA);
/*        Node node = swapPairsIteration(listA.getFirst());
        System.out.println(node);*/

        Node node = swapPairsRecursion(listA.getFirst());
        System.out.println(node.getElem());

        LinkedListUtils.traverseLinkListFromFirst(node);
    }

    /**
     * 第一次自己写这个迭代法的时候，其实就完成得差不多了，但是没有加一把劲解出来，有点可惜，一道medium的题目
     * 这个解法引入了多个变量
     * 首先要弄清楚一个东西，不能因为变量变多了人就开始晕了
     * 首先定义了三个指针变量，然后考虑到将来要返回头节点，所以这边还多了一个node是为了将来要返回的，也就是四个变量，再加上一个head变量
     * 除了变量多了点，别的都没啥，有手就行。
     * @param head
     * @return
     */
    private static Node swapPairsIteration(Node head) {
        Node dummy = new Node();
        dummy.setNext(head);

        Node pre = dummy;

        Node first = null;
        Node second = null;

        while(head != null && head.getNext() != null) {
            first = head;
            second = head.getNext();

            pre.setNext(second);
            first.setNext(second.getNext());
            second.setNext(first);

            pre = first;
            head = first.getNext();
        }
        return dummy.getNext();
    }

    /**
     * 其实拿到这个题目，我就在想能不能用递归做了。
     * 感觉没有什么好的思路。
     * 三板斧
     *      整个递归的终止条件。
     *      一级递归需要做什么？
     *      应该返回给上一级的返回值是什么？
     * 返回值应该是偶数位置的值？
     * 递归终止条件还是比较常规的。
     *
     * @param head
     * @return
     */
    private static Node swapPairsRecursion(Node head) {
        if(head == null || head.getNext() == null) {
            return head;
        }

        Node odd = head;
        Node even = head.getNext();

        odd.setNext(swapPairsRecursion(even.getNext()));
        even.setNext(odd);

        return even;
    }
}
