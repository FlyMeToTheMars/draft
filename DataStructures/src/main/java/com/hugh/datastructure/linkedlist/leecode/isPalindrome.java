package com.hugh.datastructure.linkedlist.leecode;

import com.hugh.datastructure.LinkedListUtils;
import com.hugh.datastructure.linkedlist.MySingleLinkedList;
import com.hugh.datastructure.linkedlist.Node;

import java.util.ArrayList;

/**
 * @program: draft
 * @description: 回文链表
 * @author: Fly.Hugh
 * @create: 2020-08-06 03:35
 **/
public class isPalindrome {
    public static void main(String[] args) {
        MySingleLinkedList list = LinkedListUtils.generateSingleLinkList(1, 2, 3, 3, 2, 1,3);
//        boolean flag = isPalindromeFirst(list.getFirst());

//        boolean flag = new isPalindrome().isPalindromeSecond(list.getFirst());

        boolean flag = new isPalindrome().isPalindromeThird(list.getFirst());
        System.out.println(flag);
    }

    /**
    * @author Fly.Hugh
    * @Description 首先介绍一下回文词的意思，就是正反看都一样的英文单词的意思
     * 用在这里的意思就是链表前后两个部分是呈轴对称的。
     * 在LeeCode里面这道题目判定是Easy，可能是因为并没有强制指定这道题目的时间复杂度和空间复杂度。
     * 考虑到这题的拓展，我会在这里详细描述一下这题的三种解法。
     * First:将值复制到数组中后用双指针法
     * 数组列表 底层是使用数组存储值，我们可以通过索引在 O(1) 的时间访问列表任何位置的值，这是由于内存寻址的方式。
     * 链表存储的是称为节点的对象，每个节点保存一个值和指向下一个节点的指针。访问某个特定索引的节点需要 O(n) 的时间，因为要通过指针获取到下一个位置的节点。
     * 定数组列表是否为回文很简单，我们可以使用双指针法来比较两端的元素，并向中间移动。一个指针从起点向中间移动，另一个指针从终点向中间移动。
     * 这需要 O(n) 的时间，因为访问每个元素的时间是 O(1)，而有 n 个元素要访问。
     * 直接在链表上操作并不简单，因为不论是正向访问还是反向访问都不是 O(1)。而将链表的值复制到数组列表中是 O(n)，因此最简单的方法就是将链表的值复制到数组列表中，再使用双指针法判断。
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
    /**
    * 时间复杂度：O(n)
     *    di
    **/


    // ================递归的第一种解法====================>

    /**
    * @author Fly.Hugh
    * @Description 为了解决更高要求的空间复杂度为O(n)
     * 开始考虑用递归，首先明确一点 用不用递归和空间复杂度没有绝对的关联
     * 递归的思路现捋一下，本题的递归求解，本题的递归思路 大体上和上面的数组指针是一样的。
     * 作为回文链表，从第一个节点开始往后遍历和递归到最后一个然后往前面递归比较，就可以，
     * 回文链表的话应该完全相同
     *
     * 这里需要处理的问题就是：
     * 如何在递归的过程中同时控制两边的指针比较。
     *
     * 这里不得不引入了一个外部变量，也就是这个外部变量把整个递归的空间复杂度从O(1)提升到了O(n).
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
     * 说实话 要分析一下这个递归 我并不是很懂。
     * 我滴天，我到现在居然有看不太懂的递归，惭愧。
     * 这个递归并不像之前的递归，之前我接触的递归返回的返回值总是Node
     * 我总是拿到一个Node之后再进行操作。这样的思路似乎已经成为了公示，但是这里不是。
     * 这里的递归返回值是bool类型，整体逻辑是这样的，这题不一样。
     *
     * 我居然对递归的概念还是有点不熟，
     * 要知道当某一层递归出现了return的时候并不代表了就会直接跳出循环。
     * 他会把返回值返回给上层，那么在本题中应该是个什么逻辑。
     * -- 如果在递归的过程中，一旦出现了某一层递归返回的是false，
     * 那么就要一直返回false到最后，如果是true，则无关紧要，这个逻辑和if
     * 的逻辑正好相反。
     * if(!flag(next)) = false; return true;
     * 这就是 bool型递归的真谛。
     * flag()就是函数本身，后面一级的函数返回上来的bool就是最后return的true，if true，
     * 那么就不走这个if，继续走下面的逻辑，但是如果返回的是false，
     * 就走这个逻辑然后一直走到跳出递归。也就是返回false。
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


    // <=================结束===================

    // ==================第三种方法=====================>

    /**
    * @author Fly.Hugh
    * @Description 第三种方案，为了实现空间复杂度O(n)
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
    private boolean isPalindromeThird(Node head) {

        if (head == null) return true;              // 修正

        Node firstHalfEnd  = endOfFirstHalf(head);
        Node secondHalfStart  = reverseList(firstHalfEnd);

        Node index1 = head;
        Node index2 = secondHalfStart;
        boolean flag = true;
        while(flag && index2 != null) {                       // 修正，我原先用的是 head.getNext() != null，就变成了比对最后一位的值。
            if(index1.getElem() != secondHalfStart.getElem()) {
                flag = false;
            }
            secondHalfStart = secondHalfStart.getNext();
            index1 = index1.getNext();
        }

        firstHalfEnd.setNext(reverseList(secondHalfStart));     // 修正 牛逼 牛大逼，自己的函数用两次，第一次的结果套进去再运行一次把链表指针的顺序改过来。

        return flag;

    }

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

    // 这个节点找哪一个好，是第二个链表的开端还是第一个链表的结束，明显是第一个链表的结束好
    private Node endOfFirstHalf(Node head) {
        Node fast = head;
        Node slow = head;

        while(fast.getNext().getNext() != null && fast.getNext() != null) { // 这个判断 同时判断下一个fast和slow都不是null，是否有必要？ 如果fast是null slow不是的话，根本不成立回文啊。 应该最后还是会作用在上面。
            slow = head.getNext();
            fast = head.getNext().getNext();
        }
        return slow;
    }


}
