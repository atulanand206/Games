package com.games.CodeForces.div2.R717.cut;

import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int n = sc.nextInt(), q = sc.nextInt();
        int max = (int) Math.pow(10, 4);
        List<Map<Integer, Integer>> factors = primeFactors(largestPrimes(max), max);
        int s = 0;
        for (Map<Integer, Integer> i : factors) {
            s = Math.max(i.size(), s);
        }
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) ar[i] = sc.nextInt();
        boolean[] splitAfterIndex = new boolean[n];
        int l = 0, r = n - 1;
        Set<Integer> first = factors.get(ar[l]).keySet();
        Set<Integer> second;
        Set<Integer> left = new HashSet<>(first);
        l++;
        while (l <= r) {
            second = factors.get(ar[l]).keySet();
            if (!isCoPrime(left, second)) {
                splitAfterIndex[l - 1] = true;
                left.clear();
            }
            left.addAll(second);
            l++;
        }
        int[] prefix = new int[n];
        for (int i = 1; i < n; i++)
            prefix[i] = prefix[i - 1] + (splitAfterIndex[i - 1] ? 1 : 0);
        while (q-- > 0) {
            l = sc.nextInt();
            r = sc.nextInt() - 1;
            int cnt = prefix[r] - prefix[l] + 1;
            System.out.println(cnt);
        }
    }

    private static boolean isCoPrime(Set<Integer> first, Set<Integer> second) {
        for (int i : second) if (i != 1 && first.contains(i)) return false;
        return true;
    }

    // O(N log^2(N))
    private static List<Map<Integer, Integer>> primeFactors(int[] largestPrime, int n) {
        List<Map<Integer, Integer>> list = new ArrayList<>();
        list.add(new HashMap<>());
        HashMap<Integer, Integer> map1 = new HashMap<>();
//        map1.put(1, 1);
        list.add(map1);
        for (int i = 2; i <= n; i++) list.add(factorMap(largestPrime, i));
        return list;
    }

    // O(log^2(N))
    private static Map<Integer, Integer> factorMap(int[] largestPrime, int i) {
        int x = i;
        Map<Integer, Integer> map = new HashMap<>();
        while (x != 1) {
            map.merge(largestPrime[x], 1, Integer::sum);
            x /= largestPrime[x];
        }
        return map;
    }

    // O(N log(logN))
    private static int[] largestPrimes(int n) {
        int[] largestPrime = new int[n + 1];
        largestPrime[0] = 1;
        largestPrime[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (largestPrime[i] != 0) continue;
            largestPrime[i] = i;
            for (int j = 2 * i; j <= n; j += i) largestPrime[j] = i;
        }
        return largestPrime;
    }
}
