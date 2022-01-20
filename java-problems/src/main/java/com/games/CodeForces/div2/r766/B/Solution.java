package com.games.CodeForces.div2.r766.B;

import com.games.utils.I;
import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Problem: CodeForces 1627B
 *
 * @author atulanand
 */
public class Solution {

    public static String solve(int r, int c) {
        int[] res = new int[r*c];
        int lr = r - 1, lc = c - 1;
        int mr = lr / 2, mc = lc / 2;
        res[0] = lr - mr + lc - mc;
        for (int i = res.length - 1; i + 4 > res.length - 1; i--)
            res[i] = lr + lc;


        StringBuilder sb = new StringBuilder();
        for (int re : res) sb.append(re).append(" ");
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int[] y = inputIntArray(br);
            sb.append(solve(y[0], y[1])).append("\n");
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
