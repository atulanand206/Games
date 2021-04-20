package com.games.CF.chefAndSquares;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long x = (long) 1e9;
            for (int i = 1; i < Math.sqrt(n); i++) {
                if (n % i == 0) {
                    long a = i;
                    long b = n / i;
                    if ((b - a != 0) && (b - a) % 2 == 0)
                        x = Math.min(x, (b - a) / 2);
                }
            }
            if (x != 1e9) System.out.println(x * x);
            else System.out.println(-1);
        }
    }
}
