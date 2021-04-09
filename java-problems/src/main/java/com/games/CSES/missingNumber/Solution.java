package com.games.CSES.missingNumber;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int n = sc.nextInt();
        boolean[] v = new boolean[n];
        for (int i = 1; i < n; i++) v[sc.nextInt() - 1] = true;
        for (int i = 0; i < n; i++) if (!v[i]) System.out.println(i + 1);
    }
}
