package com.games.CF.chefAndSemiPrimes;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int t = sc.nextInt();
        List<Integer> primes = primes(201);
        System.out.println(primes.size());
        while (t-- > 0) {
            int n = sc.nextInt();
            boolean isPossible = false;
            for (int i = 0; i < primes.size(); i++) {
                for (int j = 0; j < primes.size(); j++) {
                    if (i != j)
                        for (int k = 0; k < primes.size(); k++) {
                            for (int l = 0; l < primes.size(); l++) {
                                if (k != l)
                                    if (primes.get(i) * primes.get(j) + primes.get(k) * primes.get(l) == n) {
                                        isPossible = true;
                                        break;
                                    }
                            }
                            if (isPossible) break;
                        }
                    if (isPossible) break;
                }
                if (isPossible) break;
            }
            System.out.println(isPossible ? "YES" : "NO");
        }
    }

    private static List<Integer> primes(int n) {
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
