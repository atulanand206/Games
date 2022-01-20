package com.games.CodeForces.div3.r762.A;

import com.games.utils.I;
import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Problem: CodeForces 1619A
 *
 * @author atulanand
 */
public class Solution {

    public static boolean solve(String s) {
        if (s.length() % 2 != 0) return false;
        int k = s.length() / 2;
        for (int i = 0; i < k; i++)
            if (s.charAt(i) != s.charAt(i + k))
                return false;
        return true;
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
            String x = br.readLine();
            sb.append(solve(x) ? "YES" : "NO").append("\n");
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
