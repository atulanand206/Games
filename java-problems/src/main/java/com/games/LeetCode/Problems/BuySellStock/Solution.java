package com.games.LeetCode.Problems.BuySellStock;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.lang.Math.min;

public class Solution {

    public int maxProfit(int[] prices) {
        int minSoFar = Integer.MAX_VALUE;
        int maxDiff = 0;
        for (int price : prices) {
            if (price < minSoFar) {
                minSoFar = price;
            }
            int diff = price - minSoFar;
            if (diff > 0)
                maxDiff = Math.max(maxDiff, diff);
        }
        return maxDiff;
    }

    public int pips(int n) {
        int fullRows = n / 4;
        int rem = n - fullRows * 4;
        int res = 0;
        res += fullRows * 44;
        if (rem == 1 || res == 2) {
            res += 20 * rem;
        }
        if (rem == 3) {
            res += 21 * 3 - 3 - 2 * 6;
        }
        if (fullRows > 0) {
            res += (4 - rem) * 4;
        }
        return res;
    }

    public static int worthyMatrices(long[][] a, int k) {
        long[][] prefixSum2D = prefixSum2D(a);
        int R = a.length;
        int C = a[0].length;
        long[][] dp = avgs(prefixSum2D, k);
        int count = 0;
        for (int i = 1; i < R; i++)
            for (int j = 1; j < C; j++)
                count += dp[i][j];
        return count;
    }

    public static long[][] avgs(long[][] prefixSum2D, int k) {
        int r = prefixSum2D.length;
        int c = prefixSum2D[0].length;
        long[][] dp = new long[r][c];
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                System.out.printf("%d, %d\n", i, j);
                int p = min(i, j);
                long val = 0L;
                for (int z = 1; z <= p; z++) {
                    long value = value(prefixSum2D, i - z, i, j - z, j);
                    if (value >= k) {
                        // i, j, z
                        System.out.printf("%d X %d\n\n", i, j);
                        val++;
                    }
                }
                dp[i][j] = val;
            }
        }
        return dp;
    }

    private static long value(long[][] prefixSum, int x1, int x2, int y1, int y2) {
        long res = prefixSum[x2][y2];
        if (y1 > 0)
            res -= prefixSum[x2][y1 - 1];
        if (x1 > 0)
            res -= prefixSum[x1 - 1][y2];
        if (x1 > 0 && y1 > 0)
            res += prefixSum[x1 - 1][y1 - 1];
        long count = (y2 - y1 + 1) * (x2 - x1 + 1);
        long r = res / count;
        System.out.printf("(%d - %d), (%d - %d) = %d (%d / %d)\n", x1, x2, y1, y2, r, res, count);
        return r;
    }

    public static long[][] prefixSum2D(long[][] a) {
        int R = a.length;
        int C = a[0].length;
        long psa[][] = new long[R][C];
        psa[0][0] = a[0][0];
        for (int i = 1; i < C; i++)
            psa[0][i] = psa[0][i - 1] + a[0][i];
        for (int i = 1; i < R; i++)
            psa[i][0] = psa[i - 1][0] + a[i][0];
        for (int i = 1; i < R; i++)
            for (int j = 1; j < C; j++)
                psa[i][j] = psa[i - 1][j] + psa[i][j - 1] - psa[i - 1][j - 1] + a[i][j];
        return psa;
    }
}
