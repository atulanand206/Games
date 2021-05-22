package com.games.CodeForces.longJumps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] it = new int[n];
            String[] row = br.readLine().split(" ");
            for (int i = 0; i < n; i++) it[i] = Integer.parseInt(row[i]);
            int[] dp = new int[n];
            for (int i = n - 1; i >= 0; i--) {
                dp[i] = it[i];
                if (i + it[i] < n) dp[i] += dp[i + it[i]];
            }
            int max = 0;
            for (int i : dp) if (i > max) max = i;
            System.out.println(max);
        }
    }
}
