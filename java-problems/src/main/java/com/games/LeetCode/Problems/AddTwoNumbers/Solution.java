package com.games.LeetCode.Problems.AddTwoNumbers;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int fN = num(l1);
        int sN = num(l2);
        int res = fN + sN;
        return getListNode(res);
    }

    public ListNode getListNode(int res) {
        ListNode result = new ListNode(res % 10);
        ListNode node = result;
        while (res >= 10) {
            res = res / 10;
            node.next = new ListNode(res % 10);
            node = node.next;
        }
        return result;
    }

    public int num(ListNode l1) {
        int no = 0;
        int i = 0;
        while (l1 != null) {
            no = (int) (no + l1.val * Math.pow(10, i++));
            l1 = l1.next;
        }
        return no;
    }
}
