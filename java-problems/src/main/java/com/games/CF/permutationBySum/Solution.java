package com.games.CF.permutationBySum;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), l = sc.nextInt(), r = sc.nextInt(), s = sc.nextInt();
            int k = (r - l + 1);
            int[] d = new int[n + 1];
            for (int i = 1; i <= n; i++) d[i] = d[i - 1] + 1;
//            for

        }
    }
}
