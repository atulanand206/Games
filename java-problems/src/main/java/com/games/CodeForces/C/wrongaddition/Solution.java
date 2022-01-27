package com.games.CodeForces.C.wrongaddition;

import com.games.utils.I;
import com.games.utils.O;
import com.games.utils.S;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Problem: CodeForces 1619C
 *
 * @author atulanand
 */
public class Solution {

    public static String solve(long[] A) {
        StringBuilder sb = new StringBuilder();
        long a = A[0], b = A[1];
        while (a > 0 && b > 0) {
            long k = a % 10;
            long l = b % 10;
            if (l < k) {
                l = b % 100;
                b /= 100;
            } else {
                b /= 10;
            }
            if (l - k > 9 || l - k < 0) return "-1";
            sb.insert(0, (l - k));
            a /= 10;
        }
        if (b == 0 && a > 0) return "-1";
        if (b > 0 && a == 0) sb.insert(0, b);
        while (sb.length() > 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return String.valueOf(sb);
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

    public static int[] inputIntArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split(" ");
        int[] arr = new int[spec.length];
        for (int i = 0; i < spec.length; i++)
            arr[i] = Integer.parseInt(spec[i]);
        return arr;
    }

    public static long[] inputLongArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split(" ");
        long[] arr = new long[spec.length];
        for (int i = 0; i < spec.length; i++)
            arr[i] = Long.parseLong(spec[i]);
        return arr;
    }
}
