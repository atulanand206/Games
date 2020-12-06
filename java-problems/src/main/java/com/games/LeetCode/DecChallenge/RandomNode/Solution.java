package com.games.LeetCode.DecChallenge.RandomNode;

import java.util.Random;

public class Solution {

    private ListNode head;

    /**
     * @param head The linked list's head.
     *             Note that the head is guaranteed to be not null, so it contains at least one node.
     */
    public Solution(ListNode head) {
        this.head = head;
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        int size = 1;
        ListNode node = head;
        while (node.next != null) {
            size++;
            node = node.next;
        }
        node = head;
        int i = new Random().nextInt(size);
        while (i-- > 0) {
            node = node.next;
        }
        return node.val;
    }
}
