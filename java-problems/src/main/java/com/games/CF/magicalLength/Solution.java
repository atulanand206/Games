package com.games.CF.magicalLength;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int t = sc.nextInt();
        StringBuilder res = new StringBuilder();
        for (int j = 1; j <= t; j++) {
            int n = sc.nextInt();
            double[][] ar = new double[n][2];
            for (int i = 0; i < n; i++) ar[i] = new double[]{sc.nextDouble(), sc.nextDouble()};
            res.append("Case " + j + ": " + minimumDistance(ar) + "\n");
        }
        System.out.println(res);
    }

    private static double minimumDistance(double[][] ar) {
        Arrays.sort(ar, (o1, o2) -> (int) (o1[0] - o2[0]));
        double min = Double.MAX_VALUE;
        for (int i = 0; i < ar.length - 2; i++) {
            double dist = euclidDistance(ar[i], ar[i + 1])
                    + euclidDistance(ar[i + 1], ar[i + 2])
                    + euclidDistance(ar[i + 2], ar[i]);
            if (dist < min) min = dist;
        }
        Arrays.sort(ar, (o1, o2) -> (int) (o1[1] - o2[1]));
        for (int i = 0; i < ar.length - 2; i++) {
            for (int j = i + 1; j < ar.length - 1; j++) {
                if (ar[j][1] - ar[i][1] > min) break;
                for (int k = j + 1; k < ar.length; k++) {
                    if (ar[k][1] - ar[i][1] > min) break;
                    double dist = euclidDistance(ar[i], ar[j])
                            + euclidDistance(ar[j], ar[k])
                            + euclidDistance(ar[k], ar[i]);
                    if (dist < min) min = dist;
                }
            }
        }
        return min;
    }

    private static double euclidDistance(double[] first, double[] second) {
        return Math.sqrt(Math.pow(first[0] - second[0], 2) + Math.pow(first[1] - second[1], 2));
    }
}
