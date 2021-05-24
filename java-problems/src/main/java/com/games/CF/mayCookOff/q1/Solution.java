package com.games.CF.mayCookOff.q1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i1 = 3000;
        int[][] arr = new int[i1][i1];
        int k = 1, i = 0, j = 0, l = 0;
        while (i < i1 && j < i1) {
            arr[i][j] = k++;
            if (j > 0) {
                i++;
                j--;
            }
            else {
                i = 0;
                l++;
                j = l;
            }
        }
        int t = inputInt(br);
        while (t-- > 0) {
            int[] spec = inputIntArray(br);
            int x1 = spec[0] - 1, y1 = spec[1] - 1, x2 = spec[2] - 1, y2 = spec[3] - 1;
            long ans = 0;
            for (int p = x1; p <= x2; p++) {
                ans += arr[p][y1];
            }
            for (int p = y1 + 1; p <= y2; p++) {
                ans += arr[x2][p];
            }
            System.out.println(ans);
        }
    }

    public static int inputInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    public static int[] inputIntArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split(" ");
        int[] arr = new int[spec.length];
        for (int i = 0; i < spec.length; i++) arr[i] = Integer.parseInt(spec[i]);
        return arr;
    }

    public static long inputLong(BufferedReader br) throws IOException {
        return Long.parseLong(br.readLine());
    }

    public static long[] inputLongArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split(" ");
        long[] arr = new long[spec.length];
        for (int i = 0; i < spec.length; i++) arr[i] = Long.parseLong(spec[i]);
        return arr;
    }
}
