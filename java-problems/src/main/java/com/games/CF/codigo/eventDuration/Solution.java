package com.games.CF.codigo.eventDuration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] spec = br.readLine().split(" ");
        int n = Integer.parseInt(spec[0]);
        int k = Integer.parseInt(spec[1]);
        spec = br.readLine().split(" ");
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) ar[i] = Integer.parseInt(spec[i]);
        long total = 0;
        int max = 0;
        for (int i : ar) if (i > max) max = i;
        int p = max + k;
        int[] arr = new int[p];
        for (int j : ar) {
            for (int l = j; l <= j + k - 1; l++)
                arr[l] = 1;
        }
        for (int j : arr) if (j == 1) total++;
        System.out.println(total);
    }

}
