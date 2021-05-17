package com.games.CF.LRNDSA06.moonyAndIcpcTeam;

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
            long max, window_sum;
            window_sum = arr[0] + arr[1] + arr[2];
            max = window_sum;
            for (int i = 1; i < n; i++) {
                window_sum += arr[(i + 2) % n] - arr[i - 1];
                max = Math.max(window_sum, max);
            }
            System.out.println(max);
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
