package com.games.CodeForces.div3.r763.A;

import com.games.utils.I;
import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Problem: CodeForces 1623A
 *
 * @author atulanand
 */
public class Solution {

    public static int solve(int n, int m, int rx, int ry, int cx, int cy) {
        int steps = 0;
        int dx = 1, dy = 1;
        while (rx != cx && ry != cy) {
            if (rx == n) dx *= -1;
            if (ry == m) dy *= -1;
            rx += dx;
            ry += dy;
            if (rx == 0) dx *= -1;
            if (ry == 0) dy *= -1;
            steps++;
        }
        return steps;
    }



    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int[] x = inputIntArray(br);
            sb.append(solve(x[0], x[1], x[2], x[3], x[4], x[5])).append("\n");
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
