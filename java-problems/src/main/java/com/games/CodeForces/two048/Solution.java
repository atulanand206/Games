package com.games.CodeForces.two048;

import java.io.InputStreamReader;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Map<Integer, Integer> map = new TreeMap<>();
            while (n-- > 0) {
                long k = sc.nextLong();
                if (k <= 2048) map.merge((int) k, 1, Integer::sum);
            }
            PriorityQueue<Integer> set = new PriorityQueue<>(map.keySet());
            while (!set.isEmpty() && set.peek() < 2048) {
                int i = set.poll();
                if (map.get(i) > 1)
                    map.merge(i * 2, map.get(i) / 2, Integer::sum);
                if (map.keySet().contains(i * 2) && map.get(i * 2) > 0)
                    set.add(i * 2);
                set.remove(i);
                map.remove(i);
            }
            System.out.println(map.keySet().contains(2048) ? "YES" : "NO");
        }
    }
}
