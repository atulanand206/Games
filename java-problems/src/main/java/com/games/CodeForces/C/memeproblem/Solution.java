package com.games.CodeForces.C.memeproblem;

import com.games.utils.I;
import com.games.utils.O;
import com.games.utils.S;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Problem: CodeForces 1076C
 *
 * @author atulanand
 */
public class Solution {

    public static String solve(double d) {
        if (d >= 1 && d < 4) {
            return "N\n";
        }
        double low = 0, high = d;
        while (low <= high) {
            double a = (low + high) / 2;
            double b = d - a;
            double prod = a * b;
            if (Math.abs(d - prod) < Math.pow(10, -9)) {
                return String.format("Y %.9f %.9f\n", a, b);
            }
            if (prod > d) {
                low = a;
            } else {
                high = a;
            }
        }
        return "N\n";
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
//        while (t-- > 0) {
//            sb.append(solve(inputInt(br)));
//        }
        for (int i = 0; i < 1001; i++) {
            sb.append(i).append(" ").append(solve(i));
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
