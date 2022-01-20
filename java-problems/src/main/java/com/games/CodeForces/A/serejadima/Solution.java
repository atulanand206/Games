package com.games.CodeForces.A.serejadima;

import com.games.utils.I;
import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Problem: CodeForces 381A
 *
 * @author atulanand
 */
public class Solution {

    public static String solve(int[] A) {
        int sereja = 0, dima = 0;
        boolean ser = true;
        int s = 0, e = A.length - 1;
        while (s <= e) {
            int score = (A[s] > A[e]) ? A[s++] : A[e--];

            if (ser) sereja += score;
            else dima += score;

            ser = !ser;
        }
        return sereja + " " + dima;
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 1;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int k = inputInt(br);
            int[] grow = inputIntArray(br);
            sb.append(solve(grow)).append("\n");
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
