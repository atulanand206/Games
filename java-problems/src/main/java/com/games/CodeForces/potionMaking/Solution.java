package com.games.CodeForces.potionMaking;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] p = new int[]{1, 2, 4, 5, 10, 20, 25, 50, 100};
        while (t-- > 0) {
            int k = sc.nextInt();
            int min = 100 / gcd(k, 100);
            System.out.println(min);
        }
    }

    private static int gcd(int x, int y) {
        if (x == 0) return y;
        return gcd(y % x, x);
    }
}
