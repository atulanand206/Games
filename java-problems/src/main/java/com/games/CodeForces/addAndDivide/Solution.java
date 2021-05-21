package com.games.CodeForces.addAndDivide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] spec = br.readLine().split(" ");
            int a = Integer.parseInt(spec[0]), b = Integer.parseInt(spec[1]);
            int min = Integer.MAX_VALUE;
            if (a < b) {
                System.out.println(1);
                continue;
            }
            int k = b;
            if (b == 1) {
                k++;
            }
            for (int i = k; i <= (a > 1000 ? a / 2 : a); i++) {
                double lg = log(i, a);
                int at = (int) lg + (i - b);
                if (a % i != 0) at++;
                if (a > 2 && lg == (int) lg) at += 2;
                if (min > at) min = at;
                else break;
            }
            if (min == Integer.MAX_VALUE)
                min = 2;
            System.out.println(min);
        }
    }

    private static double log(double base, double logNumber) {
        return Math.log(logNumber) / Math.log(base);
    }
}
