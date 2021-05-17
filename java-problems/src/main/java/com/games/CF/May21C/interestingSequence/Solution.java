package com.games.CF.May21C.interestingSequence;

import com.games.chess.utils.ListUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    //
    private static final int max = 2500005;
//    private static final int[] largestPrime = largestPrimes(max);
//    private static final List<Map<Integer, Integer>> factors = primeFactors(largestPrime, max);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        long[] sequence = new long[max];
        sequence[0] = 1;
        sequence[1] = 4;
        for (int i = 2; i < max; i++) {
            sequence[i] = sequence[i - 1] + 2 * i + 1;
        }
        while (t-- > 0) {
            int k = inputInt(br);
            long ans = bruteForce(k, sequence);
            System.out.println(ans);
        }
    }

    private static long bruteForce(int k, long[] sequence) {
        long ans = 0;
        for (int i = 1; i <= 2 * k; i++) {
            ans += gcd((int) (k + sequence[i - 1]), (int) (k + sequence[i]));
        }
        return ans;
    }

    private static int gcd(int x, int y) {
        if (x == 0) return y;
        return gcd(y % x, x);
    }

//    private static long attempt1(int k) {
//        long ans = 0;
//        Map<Integer, Integer> kMap = factorMap(largestPrime, k);
//        ListUtils.print(kMap);
//        System.out.println((2 * k + 1));
//        for (int i = 1; i <= 2 * k; i++) {
//            System.out.println(i + 1);
//            ans += gcd(gcdMap(sumFactors(factors.get(i), kMap),
//                    sumFactors(factors.get(i + 1), kMap)));
//        }
//        return ans;
//    }
//
//    private static Map<Integer, Integer> sumFactors(Map<Integer, Integer> f1, Map<Integer, Integer> f2) {
//        Map<Integer, Integer> gcd = gcdMap(f1, f2);
//        return new HashMap<>();
//    }
//
////    private static long gcd(Map<Integer, Integer> map) {
////        long gcd = 1;
////        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
////            gcd *= Math.pow(entry.getKey(), entry.getValue());
////        }
////        return gcd;
////    }
//
//    private static Map<Integer, Integer> gcdMap(Map<Integer, Integer> f1, Map<Integer, Integer> f2) {
//        Map<Integer, Integer> gcd = new HashMap<>();
//        for (Map.Entry<Integer, Integer> entry : f1.entrySet())
//            if (f2.containsKey(entry.getKey()))
//                gcd.put(entry.getKey(), Math.min(entry.getKey(), f2.get(entry.getKey())));
//        return gcd;
//    }
//
//    public static List<Map<Integer, Integer>> primeFactors(int[] largestPrime, int n) {
//        List<Map<Integer, Integer>> list = new ArrayList<>();
//        list.add(new HashMap<>());
//        HashMap<Integer, Integer> map1 = new HashMap<>();
//        map1.put(1, 1);
//        list.add(map1);
//        for (int i = 2; i * i <= n; i++) list.add(factorMap(largestPrime, i * i));
//        return list;
//    }
//
//    public static Map<Integer, Integer> factorMap(int[] largestPrime, int i) {
//        int x = i;
//        Map<Integer, Integer> map = new HashMap<>();
//        while (x != 1) {
//            map.merge(largestPrime[x], 1, Integer::sum);
//            x /= largestPrime[x];
//        }
//        return map;
//    }
//
//    public static int[] largestPrimes(int n) {
//        int[] largestPrime = new int[n + 1];
//        largestPrime[0] = 1;
//        largestPrime[1] = 1;
//        for (int i = 2; i <= n; i++) {
//            if (largestPrime[i] != 0) continue;
//            largestPrime[i] = i;
//            for (int j = 2 * i; j <= n; j += i) largestPrime[j] = i;
//        }
//        return largestPrime;
//    }


    private static int inputInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }
}
