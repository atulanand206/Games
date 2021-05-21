package com.games.HackerEarth.MayCircuits21.binaryInversions;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int n = sc.nextInt();
        long a = sc.nextLong(), x = sc.nextLong();
        long b = n - a;
        if (b == 0) {
            if (x == 0) {
                System.out.println(new String(new char[n]).replace("\0", "0"));
            } else {
                System.out.println(-1);
            }
            return;
        }
        if (x > a * b) {
            System.out.println(-1);
            return;
        }
        long q = x / b;
        long r = x % b;
        StringBuilder sb = new StringBuilder();
        int k = 0;
        for (int i = 1; i <= a - q - 1; i++) sb.append("0 ");
        for (int i = 1; i <= r; i++) sb.append("1 ");
        sb.append("0 ");
        for (int i = 1; i <= b - r; i++) sb.append("1 ");
        for (int i = 1; i <= q; i++) sb.append("0 ");
        System.out.println(sb.toString());
    }
}
