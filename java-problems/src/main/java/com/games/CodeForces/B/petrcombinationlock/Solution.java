package com.games.CodeForces.B.petrcombinationlock;

import com.games.utils.I;
import com.games.utils.O;
import com.games.utils.S;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Problem: CodeForces 1097B
 *
 * @author atulanand
 */
public class Solution {

    private String solve(int[] A) {
        for (int i = 1; i < Math.pow(2, A.length); i++)
            if (possible(A, i)) return "YES";
        return "NO";
    }

    private boolean possible(int[] A, int x) {
        int sum = 0;
        for (int i = 0; i < A.length; i++)
            sum += ((x & (1 << i)) == (1 << i) ? 1 : -1) * A[i];
        return sum % 360 == 0;
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 1;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = inputInt(br);
            int[] x = new int[n];
            for (int i = 0; i < n; i++)
                x[i] = inputInt(br);
            sb.append(new Solution().solve(x));
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
