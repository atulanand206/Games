package com.games.CF.May21C.modular;

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
            int n = spec[0], m = spec[1];
            long cnt = 0;
            long[] arr = new long[n + 1];
            Arrays.fill(arr, 1);
            for (int i = 2; i <= n; i++) {
                int a = m % i;
                cnt += arr[a];
                for (int j = a; j <= n; j += i) {
                    arr[j]++;
                }
            }
            System.out.println(cnt);
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
