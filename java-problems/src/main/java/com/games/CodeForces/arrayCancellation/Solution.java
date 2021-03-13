package com.games.CodeForces.arrayCancellation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] ns = br.readLine().split(" ");
            int[] arr = new int[ns.length];
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(ns[i]);
            System.out.println(cancellation(arr));
        }
    }

    public static long cancellation(int[] arr) {
        int pos, neg, inx = 0;
        while ((pos = nextPositiveIndex(arr, inx)) != -1) {
            neg = nextNegativeIndex(arr, pos + 1);
            if (neg == -1) break;
            accommodateDifference(arr, pos, neg);
            inx = pos;
        }
        long coins = 0;
        inx = 0;
        while ((neg = nextNegativeIndex(arr, inx)) != -1) {
            pos = nextPositiveIndex(arr, neg + 1);
            if (pos == -1) break;
            coins += accommodateDifference(arr, pos, neg);
            inx = neg;
        }
        return coins;
    }

    private static int accommodateDifference(int[] arr, int pos, int neg) {
        int diff = absDiff(arr[pos], arr[neg]);
        arr[pos] -= diff;
        arr[neg] += diff;
        return diff;
    }

    private static int absDiff(int x, int y) {
        return Math.min(Math.abs(x), Math.abs(y));
    }

    private static int nextNegativeIndex(int[] arr, int i) {
        for (int ix = i; ix < arr.length; ix++)
            if (arr[ix] < 0)
                return ix;
        return -1;
    }

    private static int nextPositiveIndex(int[] arr, int i) {
        for (int ix = i; ix < arr.length; ix++)
            if (arr[ix] > 0)
                return ix;
        return -1;
    }
}
