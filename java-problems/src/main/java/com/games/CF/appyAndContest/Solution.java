package com.games.CF.appyAndContest;

import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong(), a = sc.nextLong(), b = sc.nextLong(), k = sc.nextLong();
            System.out.println(answer(n, a, b, k) ? "Win" : "Lose");
        }
    }

    private static boolean answer(long n, long a, long b, long k) {
        BigInteger gcd = new BigInteger(String.valueOf(a)).gcd(new BigInteger(String.valueOf(b)));
        long lcm = a * b / gcd.longValue();
        long l = n / a + n / b - 2 * n / lcm;
        return l >= k;
    }

}
