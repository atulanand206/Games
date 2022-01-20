package com.games.CodeForces.div3.r762.B;

import com.games.utils.I;
import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Problem: CodeForces 1619B
 *
 * @author atulanand
 */
public class Solution {

    public static int solve(int n) {
        return logx(n, 2) + logx(n, 3) - logx(n, 6);
    }

    private static int logx(int n, int x) {
        return (int) (Math.log(n) / Math.log(x));
    }

    // Check if a string is just one string repeated twice.
    public static boolean solve2(String s) {
        int k = s.length() / 2;
        return s.substring(0, k).equals(s.substring(k));
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int x = inputInt(br);
            sb.append(solve(x)).append("\n");
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
