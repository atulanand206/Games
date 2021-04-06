package com.games.LeetCode.Problems.BuySellStock;


import java.util.Arrays;

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
        return avgs(prefixSum2D(a), k);
    }

    public static int avgs(long[][] prefixSum2D, int k) {
        int r = prefixSum2D.length;
        int c = prefixSum2D[0].length;
        int count = 0;
        int maxOrder = Math.min(r, c);
        for (int order = 2; order <= maxOrder; order++) {
            long[] dd = new long[r];
            Arrays.fill(dd, -1L);
            for (int i = 1; i < r; i++) {
                int start = order - 1, end = c - 1;
                while (start < c && end >= 0 && start <= end) {
                    int j = (start + end) / 2;
                    long value = value(prefixSum2D, i - order + 1, i, j - order + 1, j);
                    if (value >= k) {
                        dd[i] = j;
                        end = j - 1;
                    } else {
                        start = j + 1;
                    }
                }
            }
            System.out.println(order);
            for (int i = 0; i < dd.length; i++) {
                long d = dd[i];
                if (d != -1L)
                    count += (c - d);
                System.out.printf("%d -> %d\n", i, d);
            }
            System.out.println();
        }
        return count;
    }

    private static long value(long[][] prefixSum, int x1, int x2, int y1, int y2) {
        if (x1 < 0 || y1 < 0)
            return 0L;
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
