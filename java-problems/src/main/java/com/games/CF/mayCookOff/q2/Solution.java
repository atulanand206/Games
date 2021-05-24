package com.games.CF.mayCookOff.q2;

import java.lang.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        while (t-- > 0) {
            int[] spec = inputIntArray(br);
            int n = spec[0], k = spec[1];
            int[] arr = inputIntArray(br);
            int s = 0;
            for (int i = 0; i < k; i++) s += arr[i];
            int[] sum = new int[n - k + 1];
            sum[0] = s;
            for (int i = 1; i < sum.length; i++) sum[i] = sum[i - 1] - arr[i - 1] + arr[i + k - 1];
            for (int i : sum) System.out.printf("%d ", i);
            System.out.println();
            System.out.println();
            int cnt = Integer.MAX_VALUE;
            for (int i = k; i <= n; i++) {
                int cntR = repeatMid(arr, i, k);
                if (cntR < cnt) cnt = cntR;
            }
            System.out.println(cnt);
        }
    }

    private static void print(int[] ar2) {
        for (int i : ar2) System.out.printf("%d ", i);
        System.out.println();
    }

    private static int different(int[] arr, int[] ar2) {
        int cnt = 0;
        for (int i = 0; i < ar2.length; i++)
            if (ar2[i] != arr[i]) cnt++;
        System.out.println(cnt);
        System.out.println();
        return cnt;
    }

    private static int repeatMid(int[] arr, int x, int y) {
        int[] ar2;
        ar2 = repeatRight(arr, x, y);
        ar2 = repeatLeft(ar2, x - y, y);
        print(ar2);
        return different(ar2, arr);
    }

    private static int[] repeatRight(int[] arr, int idx, int k) {
        int[] p = new int[arr.length];
        for (int i = 0; i < idx; i++) p[i] = arr[i];
        for (int i = idx; i < arr.length; i++) p[i] = p[i - k];
        return p;
    }

    private static int[] repeatLeft(int[] arr, int idx, int k) {
        int[] p = new int[arr.length];
        for (int i = idx; i < arr.length; i++) p[i] = arr[i];
        for (int i = idx - 1; i >= 0; i--) p[i] = p[i + k];
        return p;
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
