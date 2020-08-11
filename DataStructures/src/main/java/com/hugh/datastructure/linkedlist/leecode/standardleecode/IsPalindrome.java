package com.hugh.datastructure.linkedlist.leecode.standardleecode;

import com.hugh.datastructure.linkedlist.leecode.standardutils.ListNode;
import com.hugh.datastructure.linkedlist.leecode.standardutils.ListNodeUtils;

/**
 * @program: draft
 * @description: 回文链表
 * @author: Fly.Hugh
 * @create: 2020-08-08 21:27
 **/
public class IsPalindrome {
    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();

/*        System.out.println("====================对findEndOfHalf的校验====================");
        ListNode head = ListNodeUtils.generateLinkedList(1,2,3,4,5,6,7);
        ListNode slow = isPalindrom.findEndOfHalf(head);
        System.out.println(slow.val);
        System.out.println("========================================");*/

        ListNode head = ListNodeUtils.generateLinkedList(1,2,3,4,5);
        boolean palindrom = isPalindrome.isPalindrome(head);
        System.out.println(palindrom);

    }

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }

        ListNode endOfHalf = findEndOfHalf(head);
        ListNode backHead = findBackHead(endOfHalf.next);

        ListNode index1 = head;
        ListNode index2 = backHead;
        Boolean flag = true;
        while(flag == true && index2 != null) {
            if(index1.val != index2.val) {
                flag = false;
            }
            index1 = index1.next;
            index2 = index2.next;
        }

        findBackHead(backHead);

        return flag;
    }

/*    private ListNode findBackHead(ListNode head) {
        if(head.next == null) {
            return head;
        }

        ListNode next = head.next;
        ListNode newHead = findBackHead(next);
        next.next = head;
        head.next = null;

        return newHead;
    }*/

    // 头插法反转列表
    private ListNode findBackHead(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

    private ListNode findEndOfHalf(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;

        // 考虑奇数和偶数的情况
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
