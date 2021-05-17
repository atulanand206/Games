package com.games.CodeForces.redAndBlueBeans;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        while (t-- > 0) {
            int[] spec = inputIntArray(br);
            int r = spec[0], b = spec[1], d = spec[2];
            if (d == 0) {
                if (r == b) System.out.println("YES");
                else System.out.println("NO");
                continue;
            }
            int mx = Math.max(r, b);
            int mn = Math.min(r, b);
            if (mx % mn == 0 && (mx - mn) <= d)
                System.out.println("YES");
            else if (mx % mn > 0 && mx % mn <= d)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }


    private static int inputInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static int[] inputIntArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split(" ");
        int[] arr = new int[spec.length];
        for (int i = 0; i < spec.length; i++) arr[i] = Integer.parseInt(spec[i]);
        return arr;
    }
}
