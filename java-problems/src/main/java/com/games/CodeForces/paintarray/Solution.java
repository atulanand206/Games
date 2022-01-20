package com.games.CodeForces.paintarray;

import com.games.utils.I;
import com.games.utils.O;
import com.games.utils.S;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Problem: CodeForces 1618C
 *
 * @author atulanand
 */
public class Solution {

    public static long solve(long[] arr) {
        long go = arr[1], ge = arr[0];
        int k = 2;
        while (k < arr.length) {
            ge = gcd(ge, arr[k++]);
            if (k < arr.length) go = gcd(go, arr[k++]);
        }
        O.debug(S.string(go + " " + ge));
        if (go > ge) {
            for (int j = 0; j < arr.length; j += 2) {
                if (arr[j] % go == 0) return 0;
            }
            return go;
        } else if (go < ge) {
            for (int j = 1; j < arr.length; j += 2) {
                if (arr[j] % ge == 0) return 0;
            }
            return ge;
        }
        return 0;
    }

    private static long gcd(long x, long y) {
        if (x == 0) return y;
        return gcd(y % x, x);
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int x = inputInt(br);
            long[] q = inputLongArray(br);
            sb.append(solve(q)).append("\n");
        }
        System.out.println(sb);
    }

    public static int inputInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine().trim());
    }

    public static long[] inputLongArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split(" ");
        long[] arr = new long[spec.length];
        for (int i = 0; i < spec.length; i++)
            arr[i] = Long.parseLong(spec[i]);
        return arr;
    }
}
