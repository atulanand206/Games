package com.games.CodeForces.A.johnyancientcomputers;

import com.games.utils.I;
import com.games.utils.O;
import com.games.utils.S;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Problem: CodeForces 1362A
 *
 * @author atulanand
 */
public class Solution {

    public static String solve(long[] A) {
        if (A[0] % A[1] != 0 && A[1] % A[0] != 0) return "-1";
        int abs = Math.abs(cntBits(A[0]) - cntBits(A[1]));
        O.debug(S.string(abs));
        if (A[1] < A[0]) {
            int i = abs;
            while (i-- > 0) {
                if ((A[0] & 1) == 1) {
                    return "-1";
                }
                A[0] >>= 1;
            }
            if (A[0] != A[1]) return "-1";
        } else {
            int i = abs;
            while (i-- > 0) {
                A[0] <<= 1;
            }
            if (A[0] != A[1]) return "-1";
        }
        if (abs % 3 == 0) abs /= 3;
        else abs = abs / 3 + 1;
        return String.valueOf(abs);
    }

    private static int cntBits(long n) {
        int cnt = 0;
        while (n > 0) {
            cnt++;
            n >>= 1;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            sb.append(solve(inputLongArray(br))).append("\n");
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

    public static long[] inputLongArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split(" ");
        long[] arr = new long[spec.length];
        for (int i = 0; i < spec.length; i++)
            arr[i] = Long.parseLong(spec[i]);
        return arr;
    }

}
