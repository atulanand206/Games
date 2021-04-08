package com.games.CodeForces.ilyaAndQueries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args)throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String s = sc.readLine();
        int[] dp = new int[s.length() + 1];
        for (int i = 1; i < s.length(); i++)
            if (s.charAt(i) == s.charAt(i - 1)) dp[i] = dp[i - 1] + 1;
            else dp[i] = dp[i - 1];
        int q = Integer.parseInt(sc.readLine());
        while (q-- > 0) {
            String[] st = sc.readLine().trim().split(" ");
            int l = Integer.parseInt(st[0]), r = Integer.parseInt(st[1]);
            System.out.println(dp[r - 1] - dp[l - 1]);
        }
    }
}
