package com.games.CodeForces.fridgeLockers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] spec = br.readLine().split(" ");
            int n = Integer.parseInt(spec[0]), m = Integer.parseInt(spec[1]);
            int[] weights = new int[n];
            String[] row = br.readLine().split(" ");
            for (int i = 0; i < n; i++) weights[i] = Integer.parseInt(row[i]);

        }
    }
}
