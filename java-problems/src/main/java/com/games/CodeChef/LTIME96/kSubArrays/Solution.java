package com.games.CodeChef.LTIME96.kSubArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        while (t-- > 0) {
            int[] spec = inputIntArray(br);
            int n = spec[0], k = spec[1];
            int[] arr = inputIntArray(br);
            Arrays.sort(arr);
            long max = 0;
            if (k == 1) {
                long sum = 0;
                for (int j : arr) {
                    if (j < 0) {
                        max = Math.max(max, sum);
                        sum = 0;
                    } else
                        sum += j;
                }
                if (max == 0) {
                    max = Integer.MIN_VALUE;
                    for (int j : arr) {
                        max = Math.max(max, j);
                    }
                }
            }
            System.out.println(max);
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
}
