package com.games.CodeForces.B.georgeround;

import com.games.utils.I;
import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Problem: CodeForces 387B
 *
 * @author atulanand
 */
public class Solution {

    public static String solve(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int miss = 0, i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if (A[i] <= B[j]) i++;
            j++;
        }
        miss += A.length - i;
        return String.valueOf(miss);
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 1;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            inputIntArray(br);
            sb.append(solve(inputIntArray(br), inputIntArray(br)));
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
