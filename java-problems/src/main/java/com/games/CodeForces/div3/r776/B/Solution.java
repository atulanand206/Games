package com.games.CodeForces.div3.r776.B;

import com.games.utils.I;
import com.games.utils.O;
import com.games.utils.S;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Problem: CF 1650B
 *
 * @author atulanand
 */

public class Solution {
    static class Result {

        public int solve(int[] chs) {
            if (chs[0] == chs[1] || chs[2] == 1)
                return f(chs[1], chs[2]);
            int k = chs[1] / chs[2];
            int y = k * chs[2];
            int res = 0;
            if (y - 1 >= chs[0]) {
                res = Math.max(res, f(y - 1, chs[2]));
            }
            if (y >= chs[0]) {
                res = Math.max(res, f(y, chs[2]));
            }
            if (chs[1] - 1 >= chs[0]) {
                res = Math.max(res, f(chs[1] - 1, chs[2]));
            }
            if (chs[1] >= chs[0]) {
                res = Math.max(res, f(chs[1], chs[2]));
            }
            return res;
        }

        private int f(int ch, int ch1) {
            O.debug(S.string(ch + " " + ch1));
            return ch / ch1 + ch % ch1;
        }
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            sb.append(new Result().solve(inputIntArray(br))).append("\n");
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
