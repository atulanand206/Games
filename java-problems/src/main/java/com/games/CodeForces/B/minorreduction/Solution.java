package com.games.CodeForces.B.minorreduction;

import com.games.utils.I;
import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Problem: CodeForces 1626B
 *
 * @author atulanand
 */
public class Solution {

    public static String solve(int[] A) {
        int max = 0, f = -1;
        for (int i = 0; i + 1 < A.length; i++) {
            if (A[i] + A[i + 1] > max) {
                max = A[i] + A[i + 1];
                f = i;
            }
        }
        if (max <= 9) {
            f = 0;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < A.length; i++) {
            if (i == f) {
                sb.append(A[i] + A[i + 1]);
                i++;
            } else {
                sb.append(A[i]);
            }
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
            sb.append(solve(inputIntArray(br))).append("\n");
        }
        System.out.println(sb);
    }

    public static int inputInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine().trim());
    }

    public static int[] inputIntArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split("");
        int[] arr = new int[spec.length];
        for (int i = 0; i < spec.length; i++)
            arr[i] = Integer.parseInt(spec[i]);
        return arr;
    }
}
