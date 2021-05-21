package com.games.CodeForces.doubleEndedStrings;

import com.games.chess.utils.ListUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String a = br.readLine(), b = br.readLine();
            int common = LCSubStr(a.toCharArray(), b.toCharArray(), a.length(), b.length());
            System.out.println(a.length() + b.length() - 2 * common);
        }
    }

    static int LCSubStr(char[] X, char[] Y,
                        int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        int result = 0;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
                else if (X[i - 1] == Y[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Integer.max(result, dp[i][j]);
                } else dp[i][j] = 0;
            }
        }
        return result;
    }
}
