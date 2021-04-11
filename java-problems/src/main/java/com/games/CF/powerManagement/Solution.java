package com.games.CF.powerManagement;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int m = sc.nextInt(), n = sc.nextInt(), k = sc.nextInt();
        int[] f = new int[m];
        for (int i = 0; i < m; i++) f[i] = sc.nextInt();
        Arrays.sort(f);
        int tot = 0;
        for (int i = 0; i < k; i++) tot += n - f[i];
        for (int i = k; i < m; i++) tot += f[i];
        System.out.println(tot);
    }
}
