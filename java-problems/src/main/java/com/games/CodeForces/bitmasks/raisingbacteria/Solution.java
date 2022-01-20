package com.games.CodeForces.bitmasks.raisingbacteria;

import com.games.utils.I;
import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Stack;

/**
 * Problem: CodeForces 579A
 *
 * @author atulanand
 */
public class Solution {

    public static int solve(int A) {
        int cnt = 0;
        while (A > 0) {
            if ((A & 1) == 1)
                cnt++;
            A >>= 1;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
            sb.append(solve(t)).append("\n");
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
