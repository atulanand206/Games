package com.games.LeetCode.Problems.RemoveDuplicatesLinkedList;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode ptr = head;
        while (ptr.next != null) {
            ListNode next = ptr.next;
            if (ptr.val == next.val)
                ptr.next = next.next;
            else
                ptr = ptr.next;
        }
        return head;
    }
}
