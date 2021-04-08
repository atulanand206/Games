package com.games.CodeForces.sumOfOddIntegers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(sc.readLine().trim());
        while (t-- > 0) {
            String[] s = sc.readLine().trim().split(" ");
            long n = Long.parseLong(s[0]);
            long k = Long.parseLong(s[1]);
            if (k == 1) {
                System.out.println(n % 2 != 0 ? "YES" : "NO");
            } else {
                long m = (k - 1) * (2 + (k - 2) * 2) / 2;
                System.out.println(((n - m) >= (2 * (k - 1) + 1)) && ((n - m) % 2 != 0) ? "YES" : "NO");
            }
        }
    }
}