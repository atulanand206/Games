package com.games.CodeForces.serejaAndSuffixes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String[] s = sc.readLine().trim().split(" ");
        int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);
        String[] split = sc.readLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(split[i]);
        int max = 0;
        for (int i = 0; i < n; i++) if (a[i] > max) max = a[i];
        int[] dp = new int[n];
        boolean[] v = new boolean[max + 1];
        v[a[n - 1]] = true;
        dp[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (!v[a[i]]) {
                dp[i] = 1 + dp[i + 1];
                v[a[i]] = true;
            } else {
                dp[i] = dp[i + 1];
            }
        }
        while (m-- > 0)
            System.out.println(dp[Integer.parseInt(sc.readLine().trim()) - 1]);
    }
}
