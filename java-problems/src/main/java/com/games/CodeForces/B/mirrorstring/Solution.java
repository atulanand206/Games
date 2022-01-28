package com.games.CodeForces.B.mirrorstring;

import com.games.utils.I;
import com.games.utils.O;
import com.games.utils.S;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Problem: CodeForces 1616B
 *
 * @author atulanand
 */
public class Solution {

    public static String solve(char[] A) {
        StringBuilder sb = new StringBuilder();
        sb.append(A[0]);
        if (A.length > 1 && A[0] != A[1]) {
            for (int i = 1; i < A.length; i++) {
                if (A[i] <= A[i - 1]) sb.append(A[i]);
                else break;
            }
        }
        StringBuilder x = new StringBuilder(sb);
        x.reverse();
        sb.append(x);
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            inputInt(br);
            sb.append(solve(inputCharArray(br))).append("\n");
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
