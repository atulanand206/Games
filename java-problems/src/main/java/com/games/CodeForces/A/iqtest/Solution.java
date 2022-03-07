package com.games.CodeForces.A.iqtest;

import com.games.utils.I;
import com.games.utils.O;

import java.io.*;
import java.util.*;
import java.util.stream.*;

/**
 * Problem: CF 25A
 *
 * @author atulanand
 */

public class Solution {
    static class Result {
        public int solve(int n, int[] arr) {
            int oddCount = (int) IntStream.range(0, n).filter(x -> arr[x] % 2 != 0).count();
            if (oddCount == 1) {
                OptionalInt first = IntStream.range(0, n).filter(x -> arr[x] % 2 != 0).findFirst();
                return first.isPresent() ? first.getAsInt() + 1 : 0;
            }
            OptionalInt first = IntStream.range(0, n).filter(x -> arr[x] % 2 == 0).findFirst();
            return first.isPresent() ? first.getAsInt() + 1 : 0;
        }
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 1;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            sb.append(new Result().solve(inputInt(br), inputIntArray(br))).append("\n");
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
