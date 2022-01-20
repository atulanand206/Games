package com.games.CodeForces.A.twins;

import com.games.utils.I;
import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Problem: CodeForces 160A
 *
 * @author atulanand
 */
public class Solution {

    public static int solve(int[] coins) {
        int sum = 0;
        for (int i : coins) sum += i;
        Arrays.sort(coins);
        for (int i = coins.length - 2; i >= 0; i--)
            coins[i] = coins[i] + coins[i + 1];
        for (int i = coins.length - 1; i >= 0; i--)
            if (coins[i] * 2 > sum)
                return coins.length - i;
        return 0;
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 1;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = inputInt(br);
            int[] m = inputIntArray(br);
            sb.append(solve(m)).append("\n");
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
