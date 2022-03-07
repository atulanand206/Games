package com.games.CodeForces.B.balancedtunnel;

import com.games.utils.I;
import com.games.utils.O;

import java.io.*;

/**
 * Problem: CF 1237B
 *
 * @author atulanand
 */

public class Solution {
    static class Result {

        public int solve(int[] a, int[] b) {
            int[] exits = exitIndices(a,b);
            int cnt = 0, prev = -1;
            for (int i = 0; i < a.length; i++) {
                if (exits[i] > prev) {
                    prev = exits[i];
                } else {
                    cnt++;
                }
            }
            return cnt;
        }

        private int[] exitIndices(int[] a, int[] b) {
            int[] idxs = new int[a.length];
            for (int i = 0; i < b.length; i++) {
                idxs[b[i] - 1] = i;
            }
            int[] res = new int[a.length];
            for (int i = 0; i < a.length; i++) {
                res[i] = idxs[a[i] - 1];
            }
            return res;
        }

    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 1;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            inputIntArray(br);
            sb.append(new Result().solve(inputIntArray(br), inputIntArray(br))).append("\n");
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
