package com.hugh.datastructure.linkedlist.leecode;

import com.hugh.datastructure.LinkedListUtils;
import com.hugh.datastructure.linkedlist.MySingleLinkedList;
import com.hugh.datastructure.linkedlist.Node;
import sun.awt.image.ImageWatched;

import java.util.ArrayList;

/**
 * @program: draft
 * @description: 回文链表
 * @author: Fly.Hugh
 * @create: 2020-08-06 03:35
 **/
public class isPalindrome {
    public static void main(String[] args) {
        MySingleLinkedList list = LinkedListUtils.generateSingleLinkList(1, 2, 3, 3, 2, 1, 4);
//        boolean flag = isPalindromeFirst(list.getFirst());

//        boolean flag = new isPalindrome().isPalindromeSecond(list.getFirst());

        boolean flag = new isPalindrome().isPalindromeThird(list.getFirst());
        System.out.println(flag);
        System.out.println(list);
/*
        MySingleLinkedList listRecursion = LinkedListUtils.generateSingleLinkList(1, 2, 3,4,5,6,7,8,9);
        Node<Integer> node = new isPalindrome().reverseList(listRecursion.getFirst());
        System.out.println(node.getElem());
        LinkedListUtils.traverseLinkListFromFirst(node);*/

    }

    /**
    * @author Fly.Hugh
    * @Description
     * 首先介绍一下回文词的意思: 正反看都一样的英文单词
     * 这里就是链表前后两个部分是呈轴对称。
     * 在LeeCode里面这道题目难度判定是Easy，可能是因为并没有强制指定这道题目的时间复杂度和空间复杂度。
     * 贴上三种典型一点的解法：
     *
     * First:将值复制到数组中后用双指针法
     * 数组列表(ArrayList) 底层是使用数组存储值，我们可以通过索引在 O(1) 的时间访问列表任何位置的值，这是由于内存寻址的方式。
     * 链表存储的是称为节点的对象，每个节点保存一个值和指向下一个节点的指针。访问某个特定索引的节点需要 O(n) 时间，因为要通过指针获取到下一个位置的节点。
     *
     * 定数组列表是否为回文很简单，我们可以使用双指针法来比较两端的元素，并向中间移动。一个指针从起点向中间移动，另一个指针从终点向中间移动。
     *
     * 这需要 O(n) 的时间，因为访问每个元素的时间是 O(1)，而有 n 个元素要访问。
     *
     * 直接在链表上操作并不简单，因为不论是正向访问还是反向访问都不是 O(1), 下面的两种方式演示了特意用递归来解决问题。
     * 而将链表的值复制到数组列表中是 O(n)，因此最简单的方法就是将链表的值复制到数组列表中，再使用双指针法判断。
     * 因此我们可以分为两个步骤：
     * 1.复制链表值到数组列表中。
     * 2.使用双指针法判断是否为回文。
    * @Date 3:36 2020/8/6
    * @Param [head]
    * @return boolean
    **/
    private static boolean isPalindromeFirst(Node head) {
        ArrayList arr = new ArrayList<>();

        while (head != null) { //这边的判断我一开始用的是head.getNext, 是错误的，最后一个值没法放入数组。
            arr.add(head.getElem());
            head = head.getNext();
        }

        int front = 0;
        int back = arr.size() - 1;
        while(front < back) {   // 我自己解的时候这里用的是 != ，在数据个数为基数的时候无法生效
            if(((int)arr.get(front)) != ((int)arr.get(back))) {
                return false;
            }
            front ++;
            back --;
        }

        return true;
    }

    // ==================== Second ====================>>>>>>>>>>>>>>>>>>>>>>>>>

    /**
    * @author Fly.Hugh
    * @Description
     * 考虑用递归
     * 既然是回文链表，从第一个节点开始往后遍历和递归到最后一个然后往前面递归，类似双指针，每组节点的值应该都是相等的。
     *
     * 这里关键问题就是：
     * 如何在递归的过程中同时控制两边的指针比较？
     *
     * 我想了半天没想到，
     * 看了答案，引入了一个外部变量，很巧妙，不过也就是这个外部变量把整个递归的空间复杂度从O(1)提升到了O(n).
     *
    * @Date 4:40 2020/8/6
    * @Param [head]
    * @return boolean
    **/
    private boolean isPalindromeSecond(Node head) {
        firstNode = head;
        return compare(head);
    }

    private Node firstNode;

    /**
     * 这个递归并不像我之前接触的递归，之前我接触的递归返回的返回值总是Node
     * 这里的递归返回值是bool类型
     *
     * 当某一层递归出现了return的时候并不代表了就会直接跳出循环。
     * 他会把返回值返回给上层
     *
     * 本体逻辑：
     * -- 如果在递归的过程中，一旦出现了某一层递归返回的是false，
     * 那么就要一直返回false到跳出递归，如果是true，则继续逻辑判断，
     * 某些角度上来讲，这个逻辑和if的逻辑正好相反。
     *                      if(!flag(next)) = false;        return true;
     * 这就是 bool型递归的真谛。
     * flag()就是函数本身，后面一级的函数返上来的bool就是最后return的true，
     *
     * @param head
     * @return
     */
    private boolean compare(Node<Integer> head){
        if (head != null) {
            if(!compare(head.getNext())) return false;
            if (head.getElem() != firstNode.getElem()) return false;
            firstNode = firstNode.getNext();
        }
        return true;
    }


    // <<<<<<<<<<<<<<<<<<<<<<<<<==================== Finish ====================

    // ==================== Third ====================>>>>>>>>>>>>>>>>>>>>>>>>>

    /**
    * @author Fly.Hugh
    * @Description
     * 第三种方案，为了实现空间复杂度O(n)
     * 才用了一种更加复杂一点的方案
     * 题解中此种解法分为了五个步骤
     * 1 找到前半部分链表的尾节点。
     * 2 反转后半部分链表。
     * 3 判断是否为回文。
     * 4 恢复链表。
     * 5 返回结果。
    * @Date 1:23 2020/8/7
    * @Param [head]
    * @return boolean
    **/
    private boolean isPalindromeThird(Node<Integer> head) {

        if (head == null) return true;              // 修正

        Node<Integer> firstHalfEnd  = endOfFirstHalf(head);
        Node<Integer> secondHalfStart  = reverseList_interpolation(firstHalfEnd.getNext());
        LinkedListUtils.traverseLinkListFromFirst(head);

        Node<Integer> index1 = head;
        Node<Integer> index2 = secondHalfStart;
        boolean flag = true;

        while(flag && index2 != null) {                       // 修正，我原先用的是 head.getNext() != null，就变成了比对最后一位的值。 再修正，一开始用的index1 != null 会报错。 index1 遍历比index2多一位，这里面index1 和index2存在交点。
            if(index1.getElem() != index2.getElem()) {
                flag = false;
            }
            index1 = index1.getNext();
            index2 = index2.getNext();
        }

        firstHalfEnd.setNext(reverseList_interpolation(secondHalfStart));     // 修正 牛逼 牛大逼，自己的函数用两次，第一次的结果套进去再运行一次把链表指针的顺序改过来。

        return flag;
    }

    /**
     * 首先要说明 我在这里使用递归肯定是错误的，因为反转链表的时候使用递归就导致了空间复杂度到达了O(n)，
     * 整体的空间复杂度必然不可能小于这个值。
     * 然后考虑功能，虽然递归能够做到翻转链表，
     * 但是并没有切断第一段链表最后一个节点指向第二段头节点这个指向，也就是从理论上来说，
     * 1 -> 2 -> 3 -> 3 -> 2 -> 1 变成了
     * 1 -> 2 -> 3 -> 3 <- 2 <- 1
     *
     * 这里的这个特性主要是对上面值判断的时候非空判断提出了要求。
     *
     * @param head
     * @return
     */
    private Node reverseList(Node head) {
        if(head == null || head.getNext() == null) {
            return head;
        }
        Node next = head.getNext();
        Node newhead = reverseList(next);
        next.setNext(head);
        head.setNext(null);

        return newhead;
    }

    /**
     * 这里还是使用头插法来更换指针,头插法可以把空间复杂度限制在 O(1)
     *
     * @param head
     * @return
     */
    private Node reverseList_interpolation(Node head) {
        Node pre = null;
        Node cur = head;
        while (cur != null) {
            Node next = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private Node endOfFirstHalf(Node head) {
        /**
         * head有两种情况，
         * 当head是真的head节点的时候 两者都等于head可以实现模拟快慢指针，
         * 因为head是没有意义的，
         * 但是当head是first节点的时候 如果仍然用head的话，
         * 相当于slow和fast都走了相同距离的第一步 和我们预期不同
         * 所以fast用 head.Next 模拟了走两步
         * 任然符合我们对fast和slow的期待。
         */
        Node slow = head;
        Node fast = head.getNext();

        // fast.getNext() != null 理应放在前面
        while(fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    // <<<<<<<<<<<<<<<<<<<<<<<<<==================== Finish ====================
}
