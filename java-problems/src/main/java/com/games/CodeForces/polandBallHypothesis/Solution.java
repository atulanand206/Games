package com.games.CodeForces.polandBallHypothesis;

import com.games.chess.utils.ListUtils;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<Integer> primes = new TreeSet<>(primes(3000));
        for(int i = 1; ; i++) {
            int o = i * n + 1;
            if (!primes.contains(o)) {
                System.out.println(i);
                return;
            }
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
}
