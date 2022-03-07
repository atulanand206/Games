package com.games.CodeForces.div2.ER123.B;

import com.games.utils.I;
import com.games.utils.O;
import com.games.utils.S;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Problem: CodeForces 1644B
 *
 * @author atulanand
 */
public class Solution {

    public static String solve(int n) {
        if (n == 3) {
            return "3 2 1\n1 3 2\n2 3 1\n";
        }
        StringBuilder sb = new StringBuilder();
        int i = n;
        for (int j = n; j >= 1; j--) {
            for (int k = 0; k < n; k++) {
                sb.append(i).append(" ");
                i = (i - 1 + n) % n;
                if (i == 0) {
                    i = n;
                }
            }
            i = j - 1;
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
//        while (t-- > 0) {
//            sb.append(solve(inputInt(br)));
//        }
        for (int i = 3; i <= 50; i++) {
            sb.append(solve(i));
        }
        O.debug(S.string(sb));
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

    public static long[] inputLongArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split(" ");
        long[] arr = new long[spec.length];
        for (int i = 0; i < spec.length; i++)
            arr[i] = Long.parseLong(spec[i]);
        return arr;
    }
}
