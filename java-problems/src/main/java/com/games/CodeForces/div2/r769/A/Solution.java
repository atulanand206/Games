package com.games.CodeForces.div2.r769.A;

import com.games.utils.I;
import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Problem: CodeForces 1632A
 *
 * @author atulanand
 */
public class Solution {

    public static String solve(int[] a) {
        int ones = 0;
        for (int i : a) if (i == 1) ones++;
        int zeros = a.length - ones;
        return (ones <= 1 && zeros <= 1) ? "YES" : "NO";
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int y = inputInt(br);
            sb.append(solve(inputIntArray(br))).append("\n");
        }
        System.out.println(sb);
    }

    public static int inputInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine().trim());
    }

    public static int[] inputIntArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split("");
        int[] arr = new int[spec.length];
        for (int i = 0; i < spec.length; i++)
            arr[i] = Integer.parseInt(spec[i]);
        return arr;
    }
}
