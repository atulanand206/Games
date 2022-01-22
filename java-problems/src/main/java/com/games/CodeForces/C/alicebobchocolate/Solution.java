package com.games.CodeForces.C.alicebobchocolate;

import com.games.utils.I;
import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Problem: CodeForces 6C
 *
 * @author atulanand
 */
public class Solution {

    public static String solve(int[] A) {
        if (A.length == 1) return "1 0";
        int s = 0, e = A.length - 1;
        long sumA = 0, sumB = 0;
        while (s <= e) {
            if (sumA + A[s] < sumB + A[e]) {
                s++;
                sumA += A[s];
            } else if (sumA + A[s] > sumB + A[e]) {
                e--;
                sumB += A[e];
            } else {
                s++;
                sumA += A[s];
                e--;
                sumB += A[e];
            }
        }
        return s + " " + (A.length - (s));
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 1;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            inputIntArray(br);
            sb.append(solve(inputIntArray(br)));
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
