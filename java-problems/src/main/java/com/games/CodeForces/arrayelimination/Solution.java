package com.games.CodeForces.arrayelimination;

import com.games.utils.I;
import com.games.utils.O;
import com.games.utils.S;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Problem: CF 1601A
 *
 * @author atulanand
 */

public class Solution {
    static class Result {

        public String solve(int[] chs) {
            boolean[] bits = new boolean[32];
            for (int i : chs) {
                O.debug(S.string(Integer.toBinaryString(i)));
                for (int j = 0; j < 32; j++) {
                    int k = (1 << j);
                    if (k <= i) {
                        bits[j] |= (i & k) == k;
                    } else {
                        break;
                    }
                }
            }
            O.debug(S.string(bits));
            StringBuilder sb = new StringBuilder();

            return "NO";
        }
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            inputIntArray(br);
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
