package com.games.CodeForces.longcomparison;

import com.games.utils.I;
import com.games.utils.O;
import com.games.utils.S;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Problem: CodeForces 1613/A
 *
 * @author atulanand
 */
public class Solution {

    private static final int MOD = (int) 1E9 + 7;

    public static String solve(int[] n, int[] x) {
        int asl = getLength(n);
        int bsl = getLength(x);
        if (asl < bsl) return "<";
        if (asl > bsl) return ">";
        if (n[1] == x[1]) return compare(n[0], x[0]);
        int dL = Math.max(digitLength(n[0]), digitLength(x[0]));
        String as = getString(n, dL);
        String bs = getString(x, dL);
        return compare(as.compareTo(bs), 0);
    }

    private static String compare(int x, int y) {
        if (x > y) return ">";
        if (x < y) return "<";
        return "=";
    }

    private static int getLength(int[] n) {
        return digitLength(n[0]) + n[1];
    }

    private static int digitLength(int i) {
        return String.valueOf(i).length();
    }

    private static String getString(int[] n, int length) {
        StringBuilder sb = new StringBuilder();
        sb.append(n[0]);
        while(sb.length() < length) sb.append(0);
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int[] a = inputIntArray(br);
            int[] b = inputIntArray(br);
            sb.append(solve(a, b)).append("\n");
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
