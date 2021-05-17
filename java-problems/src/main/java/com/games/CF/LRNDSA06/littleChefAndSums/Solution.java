package com.games.CF.LRNDSA06.littleChefAndSums;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        while (t-- > 0) {
            int n = inputInt(br);
            int[] arr = inputIntArray(br);
            int min = Integer.MAX_VALUE;
            for (int i : arr) min = Math.min(min, i);
            int ix = 0;
            for (int i = 0; i < n; i++) if (arr[i] == min) {
                ix = i;
                break;
            }
            System.out.println(ix + 1);
        }
    }

    private static int inputInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static int[] inputIntArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split(" ");
        int[] arr = new int[spec.length];
        for (int i = 0; i < spec.length; i++) arr[i] = Integer.parseInt(spec[i]);
        return arr;
    }
}
