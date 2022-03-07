package com.games.CodeForces.B.xeniacolorfulgems;

import com.games.utils.I;
import com.games.utils.O;
import com.games.utils.S;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Problem: CodeForces 1336B
 *
 * @author atulanand
 */
public class Solution {

    private long solve(int[][] r) {
        Arrays.sort(r[0]);
        Arrays.sort(r[1]);
        Arrays.sort(r[2]);
        return search(r);
    }

    private long search(int[][] lists) {
        long res = Long.MAX_VALUE;
        for (int i = 0; i < lists.length; i++) {
            for (int j = 0; j < lists.length; j++) {
                for (int k = 0; k < lists.length; k++) {
                    if ((i == j) || (j == k) || (k == i)) continue;
                    for (int item : lists[i]) {
                        int x = lowerBound(lists[j], item);
                        int y = upperBound(lists[k], item);
                        res = Math.min(res, value(item, x, y));
                    }
                }
            }
        }
        return res;
    }

    private int lowerBound(int[] list, int target) {
        int low = 0, high = list.length - 1;
        int res = low;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (list[mid] <= target) {
                res = Math.max(res, mid);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return list[res];
    }

    private int upperBound(int[] list, int target) {
        int low = 0, high = list.length - 1;
        int res = high;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (list[mid] >= target) {
                res = Math.min(res, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return list[res];
    }

    private long value(long a, long b, long c) {
        return powSqr(a, b) + powSqr(b, c) + powSqr(c, a);
    }

    private long powSqr(long a, long b) {
        return ((a - b) * (a - b));
    }

    private long leftToRight(int[] r, int[] g, int[] b) {
        long res = Long.MAX_VALUE;
        int i = 0, j = 0, k = 0;
        while (i < r.length && j < g.length && k < b.length) {
            long val = value(r[i], g[j], b[k]);
            res = Math.min(res, val);
            int min = Math.min(r[i], Math.min(g[j], b[k]));
            O.debug(S.string(r[i] + " " + g[j] + " " + b[k]));
            if (r[i] == min && g[j] != min && b[k] != min) i++;
            else if (g[j] == min) j++;
            else k++;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int[] m = inputIntArray(br);
            int[][] numbers = new int[3][];
            numbers[0] = inputIntArray(br);
            numbers[1] = inputIntArray(br);
            numbers[2] = inputIntArray(br);
            sb.append(new Solution().solve(numbers)).append("\n");
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
