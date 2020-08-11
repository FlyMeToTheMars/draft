package com.hugh.datastructure.linkedlist.leecode.nativecode;

import com.hugh.datastructure.linkedlist.leecode.realex.ListNode;
import com.hugh.datastructure.linkedlist.leecode.realex.ListNodeUtils;

/**
 * @Author Fly.Hugh
 * @Date 2020/8/11 15:05
 * @Version 1.0
 **/
public class OddEvenLinkedList {
    public static void main(String[] args) {
        OddEvenLinkedList oddEvenLinkedList = new OddEvenLinkedList();

        ListNode node = ListNodeUtils.generateLinkedList(2,1,3,5,6,4,7);
        ListNode listNode = oddEvenLinkedList.oddEvenList(node);
        ListNodeUtils.traverseLinkListFromFirst(listNode);

    }

    /**
     * 要求：使用原地算法（一句话总结就是: 原地算法不依赖额外的资源或者依赖少数的额外资源，仅依靠输出来覆盖输入的一种算法操作。）
     * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 1->2->3->4->5->NULL
     * 输出: 1->3->5->2->4->NULL
     * 示例 2:
     * <p>
     * 输入: 2->1->3->5->6->4->7->NULL
     * 输出: 2->3->6->7->1->5->4->NULL
     * <p>
     * 说明:
     * <p>
     * 应当保持奇数节点和偶数节点的相对顺序。
     * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
     *
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode odd = head;
        ListNode even = head.next;
        while (head != null) {
            ListNode next = head.next;
            pre.next = next;
            pre = head;
            head = head.next;
        }

        ListNode findOddLast = odd;
        while (findOddLast.next != null) {
            findOddLast = findOddLast.next;
        }

        findOddLast.next = even;

        return odd;
    }
}
