package com.games.CodeChef.cook137b.meanmax;

import com.games.utils.I;
import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Problem: CodeChef Cook off
 *
 * @author atulanand
 */
public class Solution {

    public static String solve(int[] A) {
        double sum1 = A[0], sum2 = A[1];;
        int items1 = 1, items2 = 1;
        for (int i = 2; i < A.length; i++) {
            if (sum1 + A[i] < sum2 + A[i]) {
                sum1 += A[i];
                items1++;
            } else {
                sum2 += A[i];
                items2++;
            }
        }
        double mean = sum1 / items1 + sum2 / items2;
        return String.format("%.6f", mean);
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int k = inputInt(br);
            sb.append(solve(inputIntArray(br))).append("\n");
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
