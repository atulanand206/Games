package com.games.CodeForces.mexormixup;

import com.games.utils.I;
import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Problem: CodeForces 1567B
 *
 * @author atulanand
 */
public class Solution {

    private static final int MOD = (int) 1E9 + 7;

    public static int solve(int n, int x) {
        int xor = 0;
        for (int i = 0; i < n; i++) xor ^= i;
        if (xor == x) return n;
        if (xor > n) return n;
        return n + 2;
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int[] x = inputIntArray(br);
            sb.append(solve(x[0], x[1])).append("\n");
        }
        System.out.println(sb);
    }

    public static int inputInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine().trim());
    }

    public static long inputLong(BufferedReader br) throws IOException {
        return Long.parseLong(br.readLine().trim());
    }

    public static int[] inputIntArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split(" ");
        return getInts(spec);
    }

    private static int[] getInts(String[] spec) {
        int[] arr = new int[spec.length];
        for (int i = 0; i < spec.length; i++)
            arr[i] = Integer.parseInt(spec[i]);
        return arr;
    }
}
