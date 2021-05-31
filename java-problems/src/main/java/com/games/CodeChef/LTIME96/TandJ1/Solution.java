package com.games.CodeChef.LTIME96.TandJ1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        while (t-- > 0) {
            int[] spec = inputIntArray(br);
            int a = spec[0], b = spec[1], c = spec[2], d = spec[3], k = spec[4];
            int minX = Math.abs(a - c) + Math.abs(b - d);
            int extra = k - minX;
            if (extra >= 0 && extra % 2 == 0) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    public static int inputInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    public static int[] inputIntArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split(" ");
        int[] arr = new int[spec.length];
        for (int i = 0; i < spec.length; i++) arr[i] = Integer.parseInt(spec[i]);
        return arr;
    }
}
