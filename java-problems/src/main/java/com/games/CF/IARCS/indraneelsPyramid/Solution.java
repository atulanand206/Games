package com.games.CF.IARCS.indraneelsPyramid;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Math.min(sc.nextInt(), sc.nextInt());
        Arrays.sort(arr);
        for (int i = 1; i < n; i++)
            if (arr[i] - arr[i - 1] > 1) arr[i] = arr[i - 1] + 1;
        System.out.println(arr[arr.length - 1]);
    }
}
