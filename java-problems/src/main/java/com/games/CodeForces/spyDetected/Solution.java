package com.games.CodeForces.spyDetected;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            if (a[0] != a[1] && a[1] == a[2]) System.out.println(1);
            else if (a[n - 1] != a[n - 2] && a[n - 2] == a[n - 3]) System.out.println(n);
            else for (int i = 1; i < n - 1; i++) if (a[i] != a[i - 1] && a[i] != a[i + 1]) System.out.println(i + 1);
        }
    }

}
