package com.games.CodeForces.A.lifeofaflower;

import com.games.utils.I;
import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Problem: CodeForces 1585A
 *
 * @author atulanand
 */
public class Solution {

    private int solve(int[] x) {
        int res = 1;
        for (int i = 1; i < x.length; i++) {
            if (x[i - 1] == 0 && x[i] == 0) return -1;
        }
        if (x[0] == 1) res += 1;
        for (int i = 1; i < x.length; i++) {
            if (x[i - 1] == 1 && x[i] == 1) res += 5;
            else if (x[i] == 1) res += 1;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int m = inputInt(br);
            int[] x = inputIntArray(br);
            sb.append(new Solution().solve(x)).append("\n");
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
