package com.games.CodeForces.A.kirillgame;

import com.games.utils.I;
import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Problem: CodeForces 842A
 *
 * @author atulanand
 */
public class Solution {

    public static String solve(int[] A) {
        long l = A[0], r = A[1], x = A[2], y = A[3], k = A[4];
        long s = l, e = x;
        while (s <= r && e <= y) {
            if (s == e * k) return "YES";
            if (s < e * k) s++;
            else e++;
        }
        if (s == r + 1) {
            while (e <= y) {
                if ((s - 1) == e * k) return "YES";
                e++;
            }
        }
        if (e == y + 1) {
            while (s <= r) {
                if (s == (e - 1) * k) return "YES";
                s++;
            }
        }
        return "NO";
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 1;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
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
