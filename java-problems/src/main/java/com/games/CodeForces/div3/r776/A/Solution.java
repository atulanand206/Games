package com.games.CodeForces.div3.r776.A;

import com.games.utils.I;
import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Problem: CF 1650A
 *
 * @author atulanand
 */

public class Solution {
    static class Result {

        public String solve(char[] chs, char ch) {
            int last = chs.length - 1;
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == ch) {
                    if (i % 2 == 0 && (last - i) % 2 == 0) {
                        return "YES";
                    }
                }
            }
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
            sb.append(new Result().solve(inputCharArray(br), inputCharArray(br)[0])).append("\n");
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
