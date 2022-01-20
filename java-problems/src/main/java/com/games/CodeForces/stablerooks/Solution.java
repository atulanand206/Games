package com.games.CodeForces.stablerooks;

import com.games.utils.I;
import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Problem: CodeForces 1622A
 *
 * @author atulanand
 */
public class Solution {

    public static String solve(int n, int k) {
        StringBuilder sb = new StringBuilder();
        if (k > (n + 1) / 2)
            sb.append(-1).append("\n");
        else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    if (i == j && i % 2 == 0 && k-- > 0)
                        sb.append("R");
                    else sb.append('.');
                sb.append('\n');
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int[] x = inputIntArray(br);
            sb.append(solve(x[0], x[1]));
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
