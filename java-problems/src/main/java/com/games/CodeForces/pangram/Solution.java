package com.games.CodeForces.pangram;

import com.games.utils.I;
import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Problem: CodeForces 520A
 *
 * @author atulanand
 */
public class Solution {

    public static int solve(char[] conf) {
        boolean[] chars = new boolean[26];
        for (char ch : conf)
            chars[(int) ch - 97] = true;
        for (boolean b : chars)
            if (!b) return 0;
        return 1;
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        char[] x = br.readLine().trim().toLowerCase().toCharArray();
        sb.append(solve(x) == 1 ? "YES": "NO").append("\n");
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
