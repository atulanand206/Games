package com.games.CSES.diceCombinations;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int n = sc.nextInt(); long limit = (long) (Math.pow(10, 9) + 7); int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= 6; j++) if (i - j >= 0) dp[i] = (int) ((dp[i] + dp[i - j]) % limit);
        System.out.println(dp[n]);
    }
}
