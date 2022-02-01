package com.games.CodeForces.B.xeniacolorfulgems;

import com.games.utils.I;
import com.games.utils.O;
import com.games.utils.S;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Problem: CodeForces 1336B
 *
 * @author atulanand
 */
public class Solution {

    private long solve(int[] r, int[] g, int[] b) {
        Arrays.sort(r);
        Arrays.sort(g);
        Arrays.sort(b);
        return leftToRight(r, g, b);
    }

    private long leftToRight(int[] r, int[] g, int[] b) {
        long res = Long.MAX_VALUE;
        int i = 0, j = 0, k = 0;
        while (i < r.length && j < g.length && k < b.length) {
            long val = value(r[i], g[j], b[k]);
            res = Math.min(res, val);
            int min = Math.min(r[i], Math.min(g[j], b[k]));
            O.debug(S.string(r[i] + " " + g[j] + " " + b[k]));
            if (r[i] == min && g[j] != min && b[k] != min) i++;
            else if (g[j] == min) j++;
            else k++;
        }
        return res;
    }

    private long value(long a, long b, long c) {
        return powSqr(a, b) + powSqr(b, c) + powSqr(c, a);
    }

    private long powSqr(long a, long b) {
        return ((a - b) * (a - b));
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int[] m = inputIntArray(br);
            int[] r = inputIntArray(br);
            int[] g = inputIntArray(br);
            int[] b = inputIntArray(br);
            sb.append(new Solution().solve(r, g, b)).append("\n");
        }
        System.out.println(sb);
    }

    private static char[] inputCharArray(BufferedReader br) throws IOException {
        return br.readLine().trim().toCharArray();
    }

    public static int inputInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine().trim());
    }

    public static long inputLong(BufferedReader br) throws IOException {
        return Long.parseLong(br.readLine().trim());
    }

    public static int[] inputIntArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split(" ");
        int[] arr = new int[spec.length];
        for (int i = 0; i < spec.length; i++)
            arr[i] = Integer.parseInt(spec[i]);
        return arr;
    }
}
