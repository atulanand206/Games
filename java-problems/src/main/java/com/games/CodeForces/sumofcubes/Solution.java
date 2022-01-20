package com.games.CodeForces.sumofcubes;

import com.games.utils.I;
import com.games.utils.O;
import com.games.utils.S;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Problem: CodeForces 1490C
 *
 * @author atulanand
 */
public class Solution {

    private static final int MOD = (int) 1E9 + 7;

    public static boolean solve(long[] cubes, long x) {
        for (long c1 : cubes) if (search(cubes, x - c1)) return true;
        return false;
    }

    private static long[] getCubes() {
        long[] cubes = new long[10000];
        for (int i = 1; i <= cubes.length; i++) cubes[i - 1] = (long) Math.pow(i, 3);
        return cubes;
    }

    private static boolean search(long[] ar, long x) {
        int s = 0, e = ar.length - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (ar[mid] == x) return true;
            if (ar[mid] < x) s = mid + 1;
            else e = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        O.attach();
//        BufferedReader br = new BufferedReader(I.reader(true));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        long[] cubes = getCubes();
        while (t-- > 0) {
            long x = inputLong(br);
            sb.append(solve(cubes, x) ? "YES" : "NO").append("\n");
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
