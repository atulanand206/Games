package com.games.CodeForces.B.roadsidetrees;

import com.games.utils.I;
import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Problem: CodeForces 265B
 *
 * @author atulanand
 */
public class Solution {

    public static String solve(int[] trees) {
        int height = 0;
        long ans = 0;
        for (int i = 0; i < trees.length; i++) {
            ans += Math.abs(trees[i] - height) + 1;
            height = trees[i];
            if (i + 1 < trees.length) ans++;
        }
        return String.valueOf(ans);
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 1;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = inputInt(br);
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = inputInt(br);
            sb.append(solve(arr));
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
