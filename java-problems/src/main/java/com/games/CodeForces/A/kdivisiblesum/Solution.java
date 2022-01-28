package com.games.CodeForces.A.kdivisiblesum;

import com.games.utils.I;
import com.games.utils.O;
import com.games.utils.S;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Problem: CodeForces 1476A
 *
 * @author atulanand
 */
public class Solution {

    public static long solve(long[] A) {
        long n = A[0], k = A[1];
        if (n == k) return 1;
        if (n == 1) return k;
        if (k == 1) return 1;
        if (n % k == 0) return 1;
        long y;
        if (k < n) {
            int i = 1;
            for (i = 2; i * k < Integer.MAX_VALUE; i++)
                if (i * k >= n) break;
            y = i;
        } else {
            y = k / n + ((k % n == 0) ? 0 : 1);
        }
        long x = n * y;
        return (x / n) + ((x % n == 0) ? 0 : 1);
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            sb.append(solve(inputLongArray(br))).append("\n");
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

    public static long[] inputLongArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split(" ");
        long[] arr = new long[spec.length];
        for (int i = 0; i < spec.length; i++)
            arr[i] = Long.parseLong(spec[i]);
        return arr;
    }
}
