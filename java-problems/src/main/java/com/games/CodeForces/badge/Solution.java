package com.games.CodeForces.badge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] it = new int[n];
        String[] row = br.readLine().split(" ");
        for (int i = 0; i < n; i++) it[i] = Integer.parseInt(row[i]) - 1;
        int[] res = new int[n];
        for (int j = 0; j < n; j++) {
            int i = j;
            if (i == it[i]) {
                res[j] = i + 1;
                continue;
            }
            boolean[] v = new boolean[n];
            while (!v[i]) {
                v[i] = true;
                i = it[i];
            }
            res[j] = i + 1;
        }
        for (int i : res) {
            System.out.printf("%d ", i);
        }
        System.out.println();
    }
}
