package com.games.UVa.P111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.max;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int events;
        String[] chronology = null;
        String[] row;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (!line.contains(" ")) {
                events = Integer.parseInt(line);
                chronology = br.readLine().trim().split(" ");
            } else {
                row = line.split(" ");
                if (chronology != null)
                System.out.println(score(chronology, row));
            }
        }
    }

    private static int lcs(String[] X, String[] Y, int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        if (X[m - 1].equals(Y[n - 1]))
            return 1 + lcs(X, Y, m - 1, n - 1);
        else
            return max(lcs(X, Y, m, n - 1), lcs(X, Y, m - 1, n));
    }

    private static int lcs(String[] X, String[] Y) {
        int[][] dp = new int[X.length + 1][Y.length + 1];
        for (int i = 0; i < X.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < Y.length; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i < X.length; i++) {
            for (int j = 0; j < Y.length; j++) {
                if (X[i].equals(Y[j])) {
                    dp[i + 1][j + 1] = 1 + dp[i][j];
                } else {
                    dp[i + 1][j + 1] = max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
//        System.out.print("   ");
//        for (int j = 0; j < Y.length; j++) {
//            System.out.printf("%2s ", Y[j]);
//        }
//        System.out.println();
//        for (int i = 1; i < X.length+1; i++) {
//            System.out.printf("%2s ", X[i-1]);
//            for (int j = 1; j < Y.length+1; j++) {
//                System.out.printf("%2d ", dp[i][j]);
//            }
//            System.out.println();
//        }
        return dp[X.length][Y.length];
    }

    public static int score(String[] chronology, String[] row) {
        return lcs(chronology, row);
    }
}
