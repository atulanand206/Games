package com.games.CodeForces.newYearTransportation;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int n = sc.nextInt(), t = sc.nextInt();
        n--; t--;
        int[] d = new int[n];
        for (int i = 0; i < n; i++) d[i] = sc.nextInt();
        boolean[] v = new boolean[n];
        int i = 0;
        while (!v[i]) {
            v[i] = true;
            i = (i + d[i]);
            if (i == t)
                break;
            i = i % n;
        }
        System.out.println(i == t ? "YES" : "NO");
    }
}
