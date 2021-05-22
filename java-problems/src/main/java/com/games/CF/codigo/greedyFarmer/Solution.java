package com.games.CF.codigo.greedyFarmer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] spec = br.readLine().split(" ");
        int n = Integer.parseInt(spec[0]);
        int m = Integer.parseInt(spec[1]);
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        String[] chars = br.readLine().split(" ");
        for (String ch : chars) q.add(Integer.parseInt(ch));
        while (m > 0) {
            if (!q.isEmpty()) {
                int x = q.poll();
                for (int i = (int) Math.sqrt(x); i > 0; i--) {
                    if (x % i == 0) {
                        if (i - 1 <= m) {
                            m -= i - 1;
                            for (int k = 0; k < i; k++)
                                q.add(x / i);
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(q.poll());
    }

    public static Map<Integer, Integer> factorMap(int[] largestPrime, int i) {
        int x = i;
        Map<Integer, Integer> map = new HashMap<>();
        while (x != 1) {
            map.merge(largestPrime[x], 1, Integer::sum);
            x /= largestPrime[x];
        }
        return map;
    }

    public static List<Integer> primes(int n) {
        List<Integer> primes = new ArrayList<>();
        int[] largestPrime = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            if (largestPrime[i] != 0) continue;
            primes.add(i);
            for (int j = 2 * i; j <= n; j += i) largestPrime[j] = i;
        }
        return primes;
    }
}
