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
        MySingleLinkedList list = LinkedListUtils.generateSingleLinkList(1, 2, 3, 3, 2, 1);
        boolean flag = isPalindromeFirst(list.getFirst());
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
     *    第一步： 遍历链表并将值复制到数组中，O(n)。
     *    第二步：双指针判断是否为回文，执行了 O(n/2) 次的判断，即 O(n)。
     *    总的时间复杂度：O(2n)=O(n)。
     * 空间复杂度：O(n)，其中 n 指的是链表的元素个数，我们使用了一个数组列表存放链表的元素值。
    **/

    /**
    * @author Fly.Hugh
    * @Description 为了解决更高要求的空间复杂度为O(n)
     * 开始考虑用递归
    * @Date 4:40 2020/8/6
    * @Param [head]
    * @return boolean
    **/
    private static boolean isPalindromeSecond(Node head) {

        return false;
    }


}
