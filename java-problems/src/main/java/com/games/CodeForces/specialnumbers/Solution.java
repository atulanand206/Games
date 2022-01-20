package com.games.CodeForces.specialnumbers;

import com.games.utils.I;
import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Problem: CodeForces 1594/B
 *
 * @author atulanand
 */
public class Solution {

    private static final int MOD = (int) 1E9 + 7;

    public static long solve(int n, int k) {
        long ans = 0;
        long f = 1;
        while (k > 0) {
            int z = k & 1;
            if (z > 0) ans = (ans + f) % MOD;
            f = (f * n) % MOD;
            k >>= 1;
        }
        return ans;
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
