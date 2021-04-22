package com.games.CodeForces.div2.R717.B;

import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner br = new Scanner(new InputStreamReader(System.in));
        int t = br.nextInt();
        while (t-- > 0) {
            int n = br.nextInt();
            int[] ar = new int[n];
            for (int i = 0; i < n; i++) ar[i] = br.nextInt();
            solve(ar, n);
        }
    }

    private static void solve(int[] ar, int n) {
        int xs = 0;
        for (int i : ar) xs ^= i;
        if (xs == 0) {
            System.out.println("YES");
            return;
        }
        int[] x = new int[n + 1];
        for (int i = 0; i < n; i++) {
            x[i + 1] = x[i] ^ ar[i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (x[j] == 0 && x[i] == xs) {
                    System.out.println("YES");
                    return;
                }
            }
        }
        System.out.println("NO");
    }
}
