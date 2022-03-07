package com.games.CodeForces.A.pashmakandgarden;

import com.games.utils.I;
import com.games.utils.O;
import com.games.utils.S;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Problem: CF 459A
 *
 * @author atulanand
 */

public class Solution {
    static class Result {
        public String solve(int[] c) {
            int xD = Math.abs(c[0] - c[2]);
            int yD = Math.abs(c[1] - c[3]);
            if (xD == 0) {
                int xR = c[0] + yD;
                return xR + " " + c[1] + " " + xR + " " + c[3];
            }
            if (yD == 0) {
                int yR = c[1] + xD;
                return c[0] + " "  + yR + " " + c[2] + " " + yR;
            }
            if(xD == yD) {
                return c[0] + " " + c[3] + " " + c[2] + " " + c[1];
            }
            return "-1";
        }
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            sb.append(new Result().solve(inputIntArray(br))).append("\n");
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
