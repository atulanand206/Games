package com.games.CodeForces.B.fedornewgame;

import com.games.utils.I;
import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Problem: CodeForces 467B
 *
 * @author atulanand
 */
public class Solution {

    public static String solve(int n, int[] A, int x, int k) {
        int cnt = 0;
        for (int i : A)
            if (cntBits(i ^ x) <= k)
                cnt++;
        return String.valueOf(cnt);
    }

    private static int cntBits(int n) {
        int cnt = 0;
        while (n > 0) {
            cnt++;
            n = n & (n - 1);
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 1;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int[] spec = inputIntArray(br);
            int m = spec[1];
            int[] players = new int[m];
            for (int i = 0; i < m; i++) players[i] = inputInt(br);
            int fedor = inputInt(br);
            sb.append(solve(spec[0], players, fedor, spec[2]));
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
