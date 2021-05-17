package com.games.CF.IARCS.railwayCaterers;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int n = sc.nextInt(), k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int max = 0;
        int s = 0, e = k - 1;
        int sum = 0;
        for (int j = s; j <= e; j++)
            sum += arr[j];
        max = Math.max(max, sum);

        while (e != n && e - s < k) {
//            if
        }
        for (int i = k; i <= n; i++) {

//            System.out.println(sum);

            while (e < n-1) {
                sum += arr[++e] - arr[s++];
//                System.out.println(s + " " + e);
//                System.out.println(sum);
                max = Math.max(max, sum);
            }
        }
        System.out.println(max);
    }
}
