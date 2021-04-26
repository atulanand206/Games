package com.games.CodeForces.arrayAndPeaks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        while (t-- > 0) {
            int[] spec = inputIntArray(br);
            int n = spec[0], k = spec[1];
            int s = 1, e = n, p = 0;
            if (k > (n-1)/2) {
                System.out.println(-1);
                continue;
            }
            for (int i = 0; i < n; i++) {
                if (p == k) break;
                if (i % 2 == 0){
                    System.out.printf("%d ", s++);
                } else {
                    System.out.printf("%d ", e--);
                    p++;
                }
            }
            while (e >= s) System.out.printf("%d ", e--);
            System.out.println();
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
