package com.games.CF.IARCS.churuAndBalls;

import com.games.chess.utils.ListUtils;

import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static com.games.chess.utils.MathUtils.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int t = sc.nextInt();
        int max = 10000;
        List<Integer> primes = primes(max);
        List<Map<Integer, Integer>> factors = primeFactors(largestPrimes(max), max);
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
            System.out.println(minimumIncrements(primes, factors, arr));
        }
    }

    private static int minimumIncrements(List<Integer> primes, List<Map<Integer, Integer>> factors, int[] arr) {
        int inc = 0;
        // Ensures non-decreasing.
        for (int i = 1; i < arr.length; i++)
            if (arr[i] < arr[i - 1]) {
                inc += arr[i - 1] - arr[i];
                arr[i] = arr[i - 1];
            }
        int gcd = gcd(primes, factors, arr);
        System.out.println(gcd);
        for (int i : arr) {
            System.out.printf("%d: ", i);
            ListUtils.print(factors.get(i + 1));
        }
        return inc;
    }

    // O(10^7)
    private static int gcd(List<Integer> primes, List<Map<Integer, Integer>> factors, int[] arr) {
        int gcd = 1;
        for (int i : primes) {
            int k = 0, cnt = Integer.MAX_VALUE;
            for (int j : arr)
                if (factors.get(j).containsKey(i)) {
                    k++;
                    cnt = Math.min(cnt, factors.get(j).get(i));
                }
            if (k == arr.length) gcd *= Math.pow(i, cnt);
        }
        return gcd;
    }
}
