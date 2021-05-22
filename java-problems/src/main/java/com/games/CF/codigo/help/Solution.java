package com.games.CF.codigo.help;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] spec = br.readLine().split(" ");
        int n = Integer.parseInt(spec[0]);
        int k = Integer.parseInt(spec[1]);
        int x = Integer.parseInt(spec[2]);
        String[] arr = br.readLine().split(" ");
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) ar[i] = Integer.parseInt(arr[i]);
        int[] diff = new int[n];
        diff[0] = 0;
        for (int i = 1; i < n; i++) {
            if (ar[i] <= ar[i-1])
                diff[i] = 0;
            else
                diff[i] = ar[i] - ar[i-1];
        }
        int[] sum = new int[n];
        sum[0] = diff[0];
        for (int i = 1; i < n; i++) {
            if (sum[i- 1] + diff[i] > k && x > 0) {
                sum[i] = sum[i-1];
                x--;
            } else {
                sum[i] = sum[i-1] + diff[i];
            }
        }
//        for (int i : ar) System.out.printf("%d ", i);
//        System.out.println();
//        for (int i : diff) System.out.printf("%d ", i);
//        System.out.println();
//        for (int i : sum) System.out.printf("%d ", i);
//        System.out.println();
        for (int i =0 ; i<n;i++)
            if (sum[i] > k) {
                System.out.println(i - 1);
                return;
            }
        System.out.println(n - 1);
    }
}
