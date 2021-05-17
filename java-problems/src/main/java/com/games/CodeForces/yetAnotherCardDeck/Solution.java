package com.games.CodeForces.yetAnotherCardDeck;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int n = sc.nextInt(), q = sc.nextInt();
        Node head = null, current = null;
        for (int i = 0; i < n; i++) {
            Node ptr = new Node(sc.nextInt());
            if (head == null){
                head = ptr;
                current = ptr;
            } else {
                current.next = ptr;
                current = ptr;
            }
        }
        while (q-- > 0) {
            int x = sc.nextInt();
            Node ptr = head;
            Node prev = head;
            if (ptr != null && ptr.value == x) {
                System.out.printf("%d ", 1);
            } else {
                int z = 2;
                if (prev != null) {
                    ptr = prev.next;
                    while (ptr.value != x) {
                        ptr = ptr.next;
                        prev = prev.next;
                        z++;
                    }
                    prev.next = ptr.next;
                    ptr.next = head;
                    head = ptr;
                    System.out.printf("%d ", z);
                }
            }
        }
        System.out.println();
    }
}
