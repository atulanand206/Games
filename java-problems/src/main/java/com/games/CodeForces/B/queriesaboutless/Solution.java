package com.games.CodeForces.B.queriesaboutless;

import com.games.utils.I;
import com.games.utils.O;

import java.io.*;
import java.util.*;

/**
 * Problem: CF 600B
 *
 * @author atulanand
 */

public class Solution {
    static class Result {

        Map<Integer, Integer> map = new HashMap<>();

        public String solve(int[] a, int[] b) {
            Arrays.sort(a);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < b.length; i++) {
                sb.append(find(a, b[i]));
                if (i < b.length - 1) {
                    sb.append(" ");
                }
            }
            return sb.toString();
        }

        private int find(int[] arr, int k) {
            if (map.containsKey(k)) {
                return map.get(k);
            }
            int ans = arr.length - 1;
            if (arr[ans] <= k) {
                return arr.length;
            }
            int low = 0, high = ans;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid] > k) {
                    ans = Math.min(ans, mid);
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            map.put(k, ans);
            return ans;
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
