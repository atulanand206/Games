package com.games.CSES.apartments;

import com.games.utils.I;
import com.games.utils.O;
import com.games.utils.S;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Problem: CSES Apartments
 *
 * @author atulanand
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] in = inputIntArray(br);
        int[] a = inputIntArray(br);
        int[] b = inputIntArray(br);
        sb.append(solve(a, b, in[2])).append("\n");
        System.out.println(sb);
    }

    private static int solve(int[] a, int[] b, int k) {
        Arrays.sort(a);
        Arrays.sort(b);
        int cnt = 0, i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (b[j] + k < a[i]) {
                j++;
            }
            if (j < b.length && b[j] - k > a[i]) {
                i++;
            }
            if (i < a.length && j < b.length && a[i] >= (b[j] - k) && a[i] <= (b[j] + k)) {
                j++;
                i++;
                cnt++;
            }
        }
        return cnt;
    }

    public static int[] inputIntArray(BufferedReader br) throws IOException {
        return getInts(br.readLine().split(" "));
    }

    private static int[] getInts(String[] spec) {
        int[] arr = new int[spec.length];
        for (int i = 0; i < spec.length; i++)
            arr[i] = Integer.parseInt(spec[i]);
        return arr;
    }
}
