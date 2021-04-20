package com.games.CF.IARCS.endOfCorruption;

import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int n = sc.nextInt();
        int m = sc.nextInt();
        while (n + m > 0 && m > 0) {
            int t = sc.nextInt();
            if (t != -1) {
                queue.add(t);
                n--;
            } else {
                System.out.println(queue.poll());
                m--;
            }
        }
    }
}
