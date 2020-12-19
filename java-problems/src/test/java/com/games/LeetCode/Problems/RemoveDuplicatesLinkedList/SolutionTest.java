package com.games.LeetCode.Problems.RemoveDuplicatesLinkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testRemoveDuplicates() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(2);
        ListNode result = new Solution().deleteDuplicates(listNode);
        printList(result);
    }

    @Test
    void testRemoveDuplicates2() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(3);
        ListNode result = new Solution().deleteDuplicates(listNode);
        printList(result);
    }

    private void printList(ListNode result) {
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}