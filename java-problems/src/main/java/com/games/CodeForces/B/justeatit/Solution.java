package com.games.CodeForces.B.justeatit;

import com.games.utils.I;
import com.games.utils.O;

import java.io.*;

/**
 * Problem: CF 1285B
 *
 * @author atulanand
 */

public class Solution {
    static class Result {

        public String solve(int[] a) {
            if (a.length == 1) {
                return "NO";
            }
            long mid = maxSubArraySum(a, 0, a.length - 1);
            long mid2 = maxSubArraySum(a, 1, a.length);
            long sum = totalSum(a);
            long max = Math.max(mid, mid2);
            return max >= sum ? "NO" : "YES";
        }

        private long totalSum(int[] a) {
            long ans = 0;
            for (int i : a) {
                ans += i;
            }
            return ans;
        }

        private long maxSubArraySum(int[] arr, int start, int end) {
            long ans = Integer.MIN_VALUE;
            long curr = 0;
            for (int j = start; j < end; j++) {
                int i = arr[j];
                curr += i;
                if (curr > ans) {
                    ans = curr;
                }
                if (curr < 0) {
                    curr = 0;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            inputIntArray(br);
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
