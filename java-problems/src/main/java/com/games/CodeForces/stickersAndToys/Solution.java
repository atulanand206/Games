package com.games.CodeForces.stickersAndToys;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        while (t-- > 0) {
            int[] spec = inputIntArray(br);
            int n = spec[0], s = spec[1], u = spec[2];
            int ans = Math.max(n - s, n - u) + 1;
            System.out.println(ans);
        }
    }

    private static int inputInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static int[] inputIntArray(BufferedReader br) throws IOException {
        String[] s = br.readLine().split(" ");
        int[] z = new int[s.length];
        for (int i = 0; i < s.length; i++) z[i] = Integer.parseInt(s[i]);
        return z;
    }
}
