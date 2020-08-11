package com.hugh.datastructure.linkedlist.leecode.standardutils;

/**
 * @Author Fly.Hugh
 * @Date 2020/8/7 18:26
 * @Version 1.0
 **/
public class ListNodeUtils {
    public static void main(String[] args) {
        ListNode head = generateLinkedList(1, 2, 3, 4,5,6,7);
        traverseLinkListFromFirst(head);
    }

    public static ListNode generateLinkedList(int... nums){

        ListNode first = new ListNode(nums[0]);
        ListNode second;
        ListNode head = first;

        if(nums.length == 1) {
            return first;
        }

        int i;
        for (i = 0; i < nums.length - 1; i++) {
            second = new ListNode(nums[i+1]);
            first.next = second;
            first = second;
        }

        return head;
    }

    public static void traverseLinkListFromFirst(ListNode head){
        while(head != null) {
            System.out.print(head.val + ",");
            head = head.next;
        }
    }
}
