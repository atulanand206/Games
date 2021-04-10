package com.games.CSES.minimizingCoins;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int n = sc.nextInt(), x = sc.nextInt();
        int[] coins = new int[n];
        while (--n >= 0) coins[n] = sc.nextInt();
        int[] dp = new int[x + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= x; i++) {
            for (int coin : coins)
                if (i - coin >= 0) {
                    if (dp[i - coin] != Integer.MAX_VALUE && dp[i - coin] + 1 < dp[i]) dp[i] = dp[i - coin] + 1;
                }
        }
        System.out.println(dp[x] == Integer.MAX_VALUE ? -1 : dp[x]);
    }
}
