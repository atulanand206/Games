package com.games.CodeChef.LTIME96.totalComponents;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> primes = primes(10000001);
        primes.remove(0);
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(0);
        int val = 0;
        for (int k = 2; k < 10000001 && val < primes.size(); k++) {
            if (primes.get(val) == k) {
                val++;
            }
            list.add(val);
        }

        for (int i = 0; i < 100; i++) System.out.printf("%d:%d ", i, list.get(i));
        System.out.println();
        for (int i = 0; i < 100; i++) System.out.printf("%d ", primes.get(i));
        System.out.println();
        int t = inputInt(br);
        while (t-- > 0) {
            int n = inputInt(br);
            int cnt;
            // 2 4 6 8 10 12 14 16 18 20 22 24 3 5 7 9 11 15 21
            // 3 5 7 9 11 13 15 17 19 21 23 25
            // 13 17 19 23
            if (n > 2) {
                int pN = list.get(n);
                int pN2 = list.get(n >> 1);
                System.out.printf("%d %d: P", pN, pN2);
                cnt = pN - pN2 + 1;
            } else {
                cnt = 1;
            }
            System.out.println(cnt);
        }
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

    public static int inputInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }
}
