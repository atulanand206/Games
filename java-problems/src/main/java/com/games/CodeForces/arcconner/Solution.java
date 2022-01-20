package com.games.CodeForces.arcconner;

import com.games.utils.I;
import com.games.utils.O;
import com.games.utils.S;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Problem: CodeForces 1293A
 *
 * @author atulanand
 */
public class Solution {

    public static int solve(int[] closed, int n, int s) {
        Arrays.sort(closed);
        O.debug(S.string(closed));
        int idx = search(closed, s);
        if (idx == -1) return 0;
        O.debug(S.string(idx));
        int a = searchSmaller(closed, s, idx);
        int b = searchLarger(closed, s, idx, n);
        O.debug(S.string(a + " " + b));
        if (a == -1 && b != -1) return b;
        if (a != -1 && b == -1) return a;
        return Math.min(a, b);
    }

    private static int search(int[] ar, int x) {
        int s = 0, e = ar.length - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (ar[mid] == x) return mid;
            if (ar[mid] < x) s = mid + 1;
            else e = mid - 1;
        }
        return -1;
    }

    private static int searchSmaller(int[] ar, int x, int idx) {
        int s = idx;
        int ans;
        while (s > 0 && ar[s] == ar[s - 1] + 1) s--;
        ans = ar[s] - 1;
        if (s == 0 && ar[s] == 1) return -1;
        O.debug(S.string(ans));
        return Math.abs(ans - x);
    }

    private static int searchLarger(int[] ar, int x, int idx, int n) {
        int s = idx;
        int ans;
        while (s + 1 < ar.length && ar[s] == ar[s + 1] - 1) s++;
        ans = ar[s] + 1;
        O.debug(S.string(s + " - " + ans + " " + ar[s] +" "+n));
        if (s == ar.length - 1 && ar[s] == n) return -1;
        return Math.abs(ans - x);
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int[] x = inputIntArray(br);
            int[] arr = inputIntArray(br);
            sb.append(solve(arr, x[0], x[1])).append("\n");
        }
        System.out.println(sb);
    }

    public static int inputInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine().trim());
    }

    public static long inputLong(BufferedReader br) throws IOException {
        return Long.parseLong(br.readLine().trim());
    }

    public static int[] inputIntArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split(" ");
        return getInts(spec);
    }

    private static int[] getInts(String[] spec) {
        int[] arr = new int[spec.length];
        for (int i = 0; i < spec.length; i++)
            arr[i] = Integer.parseInt(spec[i]);
        return arr;
    }
}
