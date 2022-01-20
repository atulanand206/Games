package com.games.CodeForces.A.elections;

import com.games.utils.I;
import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Problem: CodeForces 1593A
 *
 * @author atulanand
 */
public class Solution {

    public static String solve(int[] A) {
        if (A[0] == A[1] && A[1] == A[2]) return "1 1 1";
        int max = Math.max(A[0], Math.max(A[1], A[2]));
        int cnt = 0;
        for (int i : A) if (i == max) cnt++;
        int a = 0, b = 0, c = 0;
        if (A[0] < max) a = max - A[0] + 1;
        if (A[1] < max) b = max - A[1] + 1;
        if (A[2] < max) c = max - A[2] + 1;
        if (cnt == 2) {
            if (A[0] == max) a = 1;
            if (A[1] == max) b = 1;
            if (A[2] == max) c = 1;
        }
        return a + " " + b + " " + c;
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int[] grow = inputIntArray(br);
            sb.append(solve(grow)).append("\n");
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
