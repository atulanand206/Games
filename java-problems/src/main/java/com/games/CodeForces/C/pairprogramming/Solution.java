package com.games.CodeForces.C.pairprogramming;

import com.games.utils.I;
import com.games.utils.O;
import com.games.utils.S;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Problem: CodeForces 1547C
 *
 * @author atulanand
 */
public class Solution {

    public static String solve(int[] A, int[] B, int lines) {
        StringBuilder sb = new StringBuilder();
        int s = 0, e =0;
        while (s < A.length && e < B.length) {
            if (A[s] > lines && B[e] > lines) return "-1";
            if (A[s] == 0 || B[e] == 0) lines++;
            if (A[s] == 0) sb.append(A[s++]);
            else if (B[e] == 0) sb.append(B[e++]);
            else sb.append((A[s] < B[e]) ? A[s++] : B[e++]);
            sb.append(" ");
        }
        while (s < A.length) {
            if (A[s] > lines) return "-1";
            if (A[s] == 0) lines++;
            sb.append(A[s++]).append(" ");
        }
        while (e < B.length) {
            if (B[e] > lines) return "-1";
            if (B[e] == 0) lines++;
            sb.append(B[e++]).append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            br.readLine();
            int[] spec = inputIntArray(br);
            int[] a = inputIntArray(br);
            int[] b = inputIntArray(br);
            sb.append(solve(a, b, spec[0])).append("\n");
        }
        System.out.println(sb);
    }

    public static int inputInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine().trim());
    }

    public static int[] inputIntArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split(" ");
        int[] arr = new int[spec.length];
        for (int i = 0; i < spec.length; i++)
            arr[i] = Integer.parseInt(spec[i]);
        return arr;
    }

    public static long inputLong(BufferedReader br) throws IOException {
        return Long.parseLong(br.readLine().trim());
    }

    private static char[] inputCharArray(BufferedReader br) throws IOException {
        return br.readLine().trim().toCharArray();
    }
}
