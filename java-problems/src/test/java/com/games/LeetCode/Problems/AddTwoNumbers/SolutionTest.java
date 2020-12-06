package com.games.LeetCode.Problems.AddTwoNumbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testNum() {
        ListNode root = new ListNode(2);
        root.next = new ListNode(4);
        root.next.next = new ListNode(3);
        assertEquals(342, new Solution().num(root));
    }

    @Test
    void testGetListNode() {
        ListNode listNode = new Solution().getListNode(807);
        while (listNode != null) {
            System.out.printf("%d ", listNode.val);
            listNode = listNode.next;
        }
    }

    @Test
    void testVerify() {
        Solution solution = new Solution();
//        solution.getListNode(9999999991);
    }

}