package com.games.CodeForces.B.antoncurrency;

import com.games.utils.I;
import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Problem: CF 508B
 *
 * @author atulanand
 */

public class Solution {
    static class Result {

        public String solve(int[] a) {
            StringBuilder sb = new StringBuilder();
            List<Integer> evens = Arrays.stream(a)
                    .boxed()
                    .filter(x -> x % 2 == 0)
                    .distinct()
                    .sorted()
                    .collect(Collectors.toList());
            if (evens.size() > 0) {
//                int x = evens.getAsInt();
//                int y = a.length - 1;
//                int first = -1, last = -1;
//                for (int i = 0; i < a.length; i++) {
//                    if (a[i] == x) {
//                        if (first == -1) {
//                            first = i;
//                        }
//                        last = i;
//                    }
//                }
//                int asInt = x < a[y] ? first : last;
//                int temp = a[y];
//                a[y] = a[asInt];
//                a[asInt] = temp;
                for (int i : a) {
                    sb.append(i);
                }
                return sb.toString();
            }
            return "-1";
        }

    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 1;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
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
        String[] spec = br.readLine().split("");
        int[] arr = new int[spec.length];
        for (int i = 0; i < spec.length; i++)
            arr[i] = Integer.parseInt(spec[i]);
        return arr;
    }
}
