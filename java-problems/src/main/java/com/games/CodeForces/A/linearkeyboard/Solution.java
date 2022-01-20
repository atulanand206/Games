package com.games.CodeForces.A.linearkeyboard;

import com.games.utils.I;
import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Problem: CodeForces 1609A
 *
 * @author atulanand
 */
public class Solution {

    public static long solve(long[] A) {
        Arrays.sort(A);
        long max = 1;
        int ix = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 != 0 && A[i] > max) {
                max = A[i];
                ix = i;
            }
        }
        if (max != 1) {
            long temp = A[ix];
            A[ix] = A[A.length - 1];
            A[A.length - 1] = temp;
        }
        int i = 0;
        while (i < A.length - 1) {
            while (A[i] % 2 == 0 && A[i] > 1) {
                A[A.length - 1] *= 2;
                A[i] /= 2;
            }
            i++;
        }
        long sum = 0;
        for (long f : A) sum += f;
        return sum;
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            inputInt(br);
            sb.append(solve(inputIntArray(br))).append("\n");
        }
        System.out.println(sb);
    }

    public static int inputInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine().trim());
    }

    public static long[] inputIntArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split(" ");
        long[] arr = new long[spec.length];
        for (int i = 0; i < spec.length; i++)
            arr[i] = Long.parseLong(spec[i]);
        return arr;
    }
}
