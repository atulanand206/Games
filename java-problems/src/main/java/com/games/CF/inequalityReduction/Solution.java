package com.games.CF.inequalityReduction;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int n = sc.nextInt();
        int r = sc.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) ar[i] = sc.nextInt();
        Arrays.sort(ar);
        long s = ar[0];
        long e = ar[n - 1];
        long ans = 0;
        while (s <= e) {
            long m = (s + e) / 2;
            long def = 0;
            boolean res = true;
            if (ar[0] < m) {
                for (int i = 0; i < n; i++) {
                    def += m - ar[i];
                    if (def > (long) (n - i - 1) * r * (i + 1)) {
                        res = false;
                        break;
                    }
                }
            }
            if (res) {
                ans = m;
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        System.out.println(ans);
    }
}
