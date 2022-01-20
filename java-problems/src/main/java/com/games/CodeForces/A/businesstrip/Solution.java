package com.games.CodeForces.A.businesstrip;

import com.games.utils.I;
import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Problem: CodeForces 149A
 *
 * @author atulanand
 */
public class Solution {

    public static int solve(int[] A, int k) {
        if (k == 0) return 0;
        Arrays.sort(A);
        int i = A.length - 2;
        while (i >= 0) {
            A[i] = A[i + 1] + A[i];
            i--;
        }
        for (i = A.length - 1; i >= 0; i--)
            if (A[i] >= k)
                return A.length - i;
        return -1;
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 1;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int k = inputInt(br);
            int[] grow = inputIntArray(br);
            sb.append(solve(grow, k)).append("\n");
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
