package com.games.CF.IARCS.speculatingBuffaloes;

import com.games.chess.utils.ListUtils;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int n = sc.nextInt(), q = sc.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) data[i] = sc.nextInt();

        int[][] value = new int[n + 1][n + 1];
        int[][] trips = new int[n + 1][n + 1];

        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int max = 0, count = 0;
                double v = 0;
                int prev = i - 1;
                for (int k = 1; k < prev; k++) {
                    double m = trips[k][prev] != 0 ? value[k][prev] / trips[k][prev] : 0;
                    if (m > v) {
                        max = value[k][prev];
                        count = trips[k][prev];
                        v = m;
                    }
                }
                prev--;
                if (prev > 0) {
                    for (int k = 1; k < prev; k++) {
                        double m = trips[k][prev] != 0 ? value[k][prev] / trips[k][prev] : 0;
                        if (m > v) {
                            max = value[k][prev];
                            count = trips[k][prev];
                            v = m;
                        }
                    }
                }

                int profit = data[i] - data[j];
                if (profit > 0) {
                    value[i][j] = max + profit;
                    trips[i][j] = count + 2;
                } else {
                    value[i][j] = max;
                    trips[i][j] = count;
                }
//                System.out.printf("i: %d, j: %d, v: %d, tr: %d\n", i, j, value[i][j], trips[i][j]);
            }
        }

        ListUtils.print2D(value);
        ListUtils.print2D(trips);
        int res = 0;
        for (int i = 1; i < n; i++)
            for (int j = i + 1; j < n; j++)
                if (trips[i][j] <= q)
                    if (value[i][j] > res)
                        res = value[i][j];
        System.out.println(res);
    }
}
