package com.games.CodeForces.div3.r764.C;

import com.games.utils.I;
import com.games.utils.O;
import com.games.utils.S;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

/**
 * Problem: CodeForces 1624C
 *
 * @author atulanand
 */
public class Solution {


    public static boolean solve(long[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++)
            while (arr[i] > n) arr[i] >>= 1;

        while (isDuplicates(arr, n)) {
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] == arr[i + 1]) {
                    arr[i] >>= 1;
                    break;
                }
            }
        }

        for (int i = 0; i < n; i++)
            if (arr[i] != i + 1) return false;
        return true;
    }

    private static boolean isDuplicates(long[] arr, int n) {
        Arrays.sort(arr);
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            inputInt(br);
            long[] x = inputLongArray(br);
            sb.append(solve(x) ? "YES" : "NO").append("\n");
        }
        System.out.println(sb);
    }

    public static int inputInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine().trim());
    }

    public static long[] inputLongArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split(" ");
        long[] arr = new long[spec.length];
        for (int i = 0; i < spec.length; i++)
            arr[i] = Long.parseLong(spec[i]);
        return arr;
    }
}
