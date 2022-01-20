package com.games.CodeForces.div2.r766.A;

import com.games.utils.I;
import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Problem: CodeForces 1627A
 *
 * @author atulanand
 */
public class Solution {

    public static int solve(char[][] conf, int r, int c) {
        int black = 0;
        boolean rowOrColumn = false;
        for (int i = 0; i < conf.length; i++) {
            char[] row = conf[i];
            for (int j = 0; j < row.length; j++) {
                char ch = row[j];
                if (ch == 'B') {
                    black++;
                    if (i == r || j == c)
                        rowOrColumn = true;
                }
            }
        }
        if (black == 0) return -1;
        if (conf[r][c] == 'B') return 0;
        if (rowOrColumn) return 1;
        return 2;
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int[] y = inputIntArray(br);
            char[][] in = new char[y[0]][];
            for (int i = 0; i < in.length; i++)
                in[i] = br.readLine().trim().toCharArray();
            sb.append(solve(in, y[2] - 1, y[3] - 1)).append("\n");
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
