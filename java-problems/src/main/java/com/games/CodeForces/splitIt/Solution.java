package com.games.CodeForces.splitIt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        while (t-- > 0) {
            int[] spec = inputIntArray(br);
            int k = spec[1];
            String s = br.readLine();
            if (s.length() < 2 * k + 1) {
                System.out.println("NO");
                continue;
            }
            String left = s.substring(0, k);
            String right = s.substring(s.length() - k);
            String reverse = new StringBuilder(right).reverse().toString();
            if (left.equals(reverse)) System.out.println("YES");
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
