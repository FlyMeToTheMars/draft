package com.hugh.datastructure.linkedlist.leecode.nativecode;

import com.hugh.datastructure.linkedlist.leecode.realex.ListNode;
import com.hugh.datastructure.linkedlist.leecode.realex.ListNodeUtils;

/**
 * @Author Fly.Hugh
 * @Date 2020/8/11 10:20
 * @Version 1.0
 **/
public class SplitLinkedListInParts {
    public static void main(String[] args) {
        SplitLinkedListInParts split = new SplitLinkedListInParts();

        ListNode node = ListNodeUtils.generateLinkedList(1,2,3,4);
        ListNode[] listNodes = split.splitListToParts(node, 5);
        System.out.println(listNodes);
    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        int listSize = getSize(root);

        int standardLength = listSize / k;
        int lengthenLength = standardLength + 1;

        int lengthenPartsNums = listSize % k;
        int lengthenPartsCount = lengthenPartsNums;

        ListNode[] listNodeTail = new ListNode[k];
        ListNode[] listNodeHead = new ListNode[k];

        int index = 1;
        int arrIndex = 0;
        listNodeHead[0] = root;
        while(root != null) {
            if (lengthenPartsCount > 0 && index % lengthenLength == 0) {
                listNodeTail[arrIndex] = root;
                arrIndex++;
                listNodeHead[arrIndex] = root.next;
                lengthenPartsCount--;
            } else if (lengthenPartsCount == 0 && (index - lengthenLength * lengthenPartsNums) % standardLength == 0) {
                listNodeTail[arrIndex] = root;
                arrIndex++;
                if (arrIndex < k) listNodeHead[arrIndex] = root.next;
            }

            root = root.next;
            index++;
        }

        for (ListNode node:
                listNodeTail) {
            if (node != null && node.next != null) {
                node.next = null;
            }
        }

        return listNodeHead;
    }

    private int getSize(ListNode root) {
        int length = 0;

        while (root != null) {
            length++;
            root = root.next;
        }

        return length;
    }


}
