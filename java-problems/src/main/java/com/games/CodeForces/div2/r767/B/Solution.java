package com.games.CodeForces.div2.r767.B;

import com.games.utils.I;
import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Problem: CodeForces 1629B
 *
 * @author atulanand
 */
public class Solution {

    public static String solve(int l, int r, int k) {
        if (l == r) return l == 1 ? "NO" : "YES";
        int window = r - l + 1;
        int odds = window / 2;
        if (l % 2 != 0 && window % 2 != 0) odds++;
        return odds <= k ? "YES" : "NO";
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int[] y = inputIntArray(br);
            sb.append(solve(y[0], y[1], y[2])).append("\n");
        }
        System.out.println(sb);
    }

    public static int inputInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine().trim());
    }

    public static int[] inputIntArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split(" ");
        int[] arr = new int[spec.length];
        for (int i = 0; i < spec.length; i++)
            arr[i] = Integer.parseInt(spec[i]);
        return arr;
    }
}
