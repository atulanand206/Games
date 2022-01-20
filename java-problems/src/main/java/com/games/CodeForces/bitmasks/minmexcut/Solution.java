package com.games.CodeForces.bitmasks.minmexcut;

import com.games.utils.I;
import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Problem: CodeForces 1566B
 *
 * @author atulanand
 */
public class Solution {

    public static int solve(int[] A) {
        int l = 0, r = A.length - 1;
        while (l <= r && A[l] == 1) l++;
        while (r >= l && A[r] == 1) r--;
        if (l > r) return 0;
        int o = 0;
        while (l <= r) {
            if (A[l] == 1) o++;
            l++;
        }
        return o > 0 ? 2 : 1;
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int[] a = inputIntArray(br);
            sb.append(solve(a)).append("\n");
        }
        System.out.println(sb);
    }

    public static int inputInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine().trim());
    }

    public static int[] inputIntArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split("");
        int[] arr = new int[spec.length];
        for (int i = 0; i < spec.length; i++)
            arr[i] = Integer.parseInt(spec[i]);
        return arr;
    }
}
