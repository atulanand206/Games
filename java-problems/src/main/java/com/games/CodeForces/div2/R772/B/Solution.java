package com.games.CodeForces.div2.R772.B;

import com.games.utils.I;
import com.games.utils.O;
import com.games.utils.S;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Problem: CodeForces 1635B
 *
 * @author atulanand
 */
public class Solution {

    public static String solve(int[] a) {
        int changes = 0;
        O.debug(S.string(a));
        int[] x = new int[a.length];
        for (int i = 1; i + 1 < a.length; i++) {
            if (a[i - 1] < a[i] && a[i + 1] < a[i]) {
                x[i] = 1;
            }
        }
        for (int i = 1; i + 1 < a.length; i++) {
            if (x[i - 1] == 1 && x[i] == 0 && x[i + 1] == 1) {
                a[i] = Math.max(a[i - 1], a[i + 1]);
                x[i + 1] = 0;
                x[i - 1] = 0;
                changes++;
            }
            O.debug(S.string(x));
        }
        for (int i = 1; i + 1 < a.length; i++) {
            if (x[i - 1] == 0 && x[i] == 1 && x[i + 1] == 0) {
                a[i] = Math.max(a[i - 1], a[i + 1]);
                x[i] = 0;
                changes++;
            }
            O.debug(S.string(x));
        }
        O.debug(S.string(x));
        O.debugNewLine();
        StringBuilder sb = new StringBuilder(changes + "\n");
        for (int i : a) {
            sb.append(i).append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int y = inputInt(br);
            int[] a = inputIntArray(br);
            sb.append(solve(a)).append("\n");
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
