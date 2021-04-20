package com.games.chess.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MathUtils {

    // O(N log(logN))
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

    public static int[][] prefixKPrimes(int[] count, int k) {
        int size = count.length;
        int[][] pref = new int[k + 1][size];
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j < size; j++) {
                if (count[j] == i) pref[i][j] = pref[i][j - 1] + 1;
                else pref[i][j] = pref[i][j - 1];
            }
        }
        return pref;
    }

    public static int[] distinctPrimeCount(List<Map<Integer, Integer>> primeFactors) {
        int[] res = new int[primeFactors.size()];
        for (int i = 1; i < primeFactors.size(); i++) res[i] = primeFactors.get(i).size();
        return res;
    }

    // O(N log(logN))
    public static int[] largestPrimes(int n) {
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

    // O(N log^2(N))
    public static List<Map<Integer, Integer>> primeFactors(int[] largestPrime, int n) {
        List<Map<Integer, Integer>> list = new ArrayList<>();
        list.add(new HashMap<>());
        HashMap<Integer, Integer> map1 = new HashMap<>();
        map1.put(1, 1);
        list.add(map1);
        for (int i = 2; i <= n; i++) list.add(factorMap(largestPrime, i));
        return list;
    }

    // O(log^2(N))
    public static Map<Integer, Integer> factorMap(int[] largestPrime, int i) {
        int x = i;
        Map<Integer, Integer> map = new HashMap<>();
        while (x != 1) {
            map.merge(largestPrime[x], 1, Integer::sum);
            x /= largestPrime[x];
        }
        return map;
    }
}
