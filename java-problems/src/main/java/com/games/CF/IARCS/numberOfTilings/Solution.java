package com.games.CF.IARCS.numberOfTilings;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i - 1] + 2 * dp[i - 2] + 5 * dp[i - 3])%10000000;
        }
        System.out.println(dp[n]);
    }
}
