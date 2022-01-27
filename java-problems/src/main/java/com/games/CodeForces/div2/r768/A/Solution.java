package com.games.CodeForces.div2.r768.A;

import com.games.utils.I;
import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Problem: CodeForces 1631A
 *
 * @author atulanand
 */
public class Solution {

    public static int solve(int[] a, int[] b) {
        int max = 1, min = 1;
        for (int i = 0; i < a.length; i++) {
            max = Math.max(max, Math.max(a[i], b[i]));
            min = Math.max(min, Math.min(a[i], b[i]));
        }
        return max * min;
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int y = inputInt(br);
            int[] a = inputIntArray(br);
            int[] b = inputIntArray(br);
            sb.append(solve(a, b)).append("\n");
        }
        System.out.println(sb);
    }

    public static int inputInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine().trim());
    }

    public static int[] inputIntArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split(" ");
        int[] arr = new int[spec.length];
        for (int i = 0; i < spec.length; i++)
            arr[i] = Integer.parseInt(spec[i]);
        return arr;
    }
}
