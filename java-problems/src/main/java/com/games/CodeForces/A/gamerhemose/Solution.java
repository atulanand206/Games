package com.games.CodeForces.A.gamerhemose;

import com.games.utils.I;
import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Problem: CodeForces 1592A
 *
 * @author atulanand
 */
public class Solution {

    public static long solve(int[] A, int H) {
        int mx = maxIndex(A, -1);
        int nx = maxIndex(A, mx);
        int mn = minIndex(A);
        long low = 1, high = H / A[mn] + 1;
        long ans = high;
        while (low <= high) {
            long mid = (low + high) / 2;
            long md2 = mid / 2;
            long val = A[nx] * md2 + A[mx] * (mid - md2);
            if (val < H) {
                low = mid + 1;
            } else {
                ans = Math.min(ans, mid);
                high = mid - 1;
            }
        }
        return ans;
    }

    private static int minIndex(int[] a) {
        int i = 0, min = a[0];
        for (int j = i + 1; j < a.length; j++)
            if (a[j] < min) {
                i = j;
                min = a[j];
            }
        return i;
    }

    private static int maxIndex(int[] a, int ex) {
        int i = 0, max = a[0];
        for (int j = i + 1; j < a.length; j++)
            if (j != ex && a[j] > max) {
                i = j;
                max = a[j];
            }
        return i;
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int[] spec = inputIntArray(br);
            int[] grow = inputIntArray(br);
            sb.append(solve(grow, spec[1])).append("\n");
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
