package com.games.CodeForces.div2.er120.A;

import com.games.utils.I;
import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Problem: CodeForces 1622A
 *
 * @author atulanand
 */
public class Solution {

    public static boolean solve(int a, int b, int c) {
        if (a == b && c % 2 == 0) return true;
        if (a == c && b % 2 == 0) return true;
        if (c == b && a % 2 == 0) return true;
        if (a + b == c) return true;
        if (a + c == b) return true;
        if (b + c == a) return true;
        return false;
    }



    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int[] x = inputIntArray(br);
            sb.append(solve(x[0], x[1], x[2]) ? "YES" : "NO").append("\n");
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
