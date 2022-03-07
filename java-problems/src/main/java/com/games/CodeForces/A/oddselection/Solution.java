package com.games.CodeForces.A.oddselection;

import com.games.utils.I;
import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Problem: CF 1363A
 *
 * @author atulanand
 */

class Result {
    public int solve(int[] arr, int k) {
        int oddCount = (int) Arrays.stream(arr).filter(x -> x % 2 != 0).count();
        if (k == arr.length && oddCount % 2 == 0) {
            return 0;
        }
        if (oddCount == arr.length && k % 2 == 0) {
            return 0;
        }
        return oddCount > 0 ? 1 : 0;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int[] specs = inputIntArray(br);
            int[] arr = inputIntArray(br);
            sb.append(new Result().solve(arr, specs[1]) == 1 ? "Yes" : "No").append("\n");
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
