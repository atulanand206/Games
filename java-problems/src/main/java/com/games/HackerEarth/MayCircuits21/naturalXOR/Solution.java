package com.games.HackerEarth.MayCircuits21.naturalXOR;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private static int xor(int n) {
        int mod = n % 4;
        if (mod == 0) return n;
        if (mod == 1) return 1;
        if (mod == 2) return n + 1;
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = n % 4;
            if (k == 3) k = 0;
            else if (k == 0) k = 1;
            else if (k == 1) k = 2;
            else if (k == 2) k = 3;
            if (n < 3) k--;
            StringBuilder sb = new StringBuilder();
            sb.append(k).append(" ");
            for (int i = n; i > n - k; i--) sb.append(i).append(" ");
            System.out.println(sb);
        }
    }
}
