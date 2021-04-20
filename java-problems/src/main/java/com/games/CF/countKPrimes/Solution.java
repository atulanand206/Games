package com.games.CF.countKPrimes;

import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static int max = (int) Math.pow(10, 5);

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int t = sc.nextInt();
        int[][] pref = prefix(distinctPrimeCount(primeFactors(largestPrimes(max), max)), 5);
        while (t-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt(), k = sc.nextInt();
            System.out.println(pref[k][b] - pref[k][a - 1]);
        }
    }

    private static int[][] prefix(int[] count, int k) {
        int size = count.length;
        int[][] pref = new int[k+1][size];
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j < size; j++) {
                if (count[j] == i) pref[i][j] = pref[i][j - 1] + 1;
                else pref[i][j] = pref[i][j - 1];
            }
        }
        return pref;
    }

    private static int[] distinctPrimeCount(List<Map<Integer, Integer>> primeFactors) {
        int[] res = new int[primeFactors.size()];
        for (int i = 1; i < primeFactors.size(); i++) res[i] = primeFactors.get(i).size();
        return res;
    }

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

    private static List<Map<Integer, Integer>> primeFactors(int[] largestPrime, int n) {
        List<Map<Integer, Integer>> list = new ArrayList<>();
        list.add(new HashMap<>());
        HashMap<Integer, Integer> map1 = new HashMap<>();
        map1.put(1, 1);
        list.add(map1);
        for (int i = 2; i <= n; i++) list.add(factorMap(largestPrime, i));
        return list;
    }

    private static Map<Integer, Integer> factorMap(int[] largestPrime, int i) {
        int x = i;
        Map<Integer, Integer> map = new HashMap<>();
        while (x != 1) {
            map.merge(largestPrime[x], 1, Integer::sum);
            x /= largestPrime[x];
        }
        return map;
    }
}
