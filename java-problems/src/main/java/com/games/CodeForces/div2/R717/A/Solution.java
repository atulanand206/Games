package com.games.CodeForces.div2.R717.A;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner br = new Scanner(new InputStreamReader(System.in));
        int t = br.nextInt();
        while (t-- > 0) {
            int n = br.nextInt();
            int k = br.nextInt();
            int[] ar = new int[n];
            for (int i = 0; i < n; i++) ar[i] = br.nextInt();
            int i = 0;
            while (k > 0) {
                if (ar[i] > 0) {
                    ar[i]--;
                    ar[ar.length - 1]++;
                    k--;
                } else {
                    i++;
                }
                if (i == ar.length - 1) {
                    k = 0;
                }
            }
            for (int p : ar) System.out.printf("%d ", p);
            System.out.println();
        }
    }
}
