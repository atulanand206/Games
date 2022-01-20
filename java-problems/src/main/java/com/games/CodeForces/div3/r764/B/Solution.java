package com.games.CodeForces.div3.r764.B;

import com.games.utils.I;
import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.games.utils.O.debug;
import static com.games.utils.O.debugNewLine;

/**
 * Problem: CodeForces 1624B
 *
 * @author atulanand
 */
public class Solution {

    public static boolean solve(long[] arr) {
        return edge(arr[0], arr[1], arr[2])
                || isMidPos(arr[0], arr[1], arr[2])
                || edge(arr[2], arr[1], arr[0]);
    }

    public static boolean isMidPos(long a, long b, long c) {
        long md = (a + c);
        if (md % 2 != 0) return false;
        md /= 2;
        return md % b == 0;
    }

    public static boolean edge(long a, long b, long c) {
        long md = 2 * b - a;
        if (md <= 0) return false;
        return md % c == 0;
    }

    public static boolean isLeftPos(long[] arr) {
        long md = 2 * arr[1] - arr[2];
        if (md <= 0) return false;
        return md % arr[0] == 0;
    }

    public static boolean isRightPos(long[] arr) {
        long md = 2 * arr[1] - arr[0];
        if (md <= 0) return false;
        return md % arr[2] == 0;
    }

    public static void main(String[] args) throws IOException {
        O.attach();
//        BufferedReader br = new BufferedReader(I.reader(true));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            long[] x = inputLongArray(br);
            sb.append(solve(x) ? "YES" : "NO").append("\n");
        }
        System.out.println(sb);
    }

    public static int inputInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine().trim());
    }

    public static long[] inputLongArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split(" ");
        long[] arr = new long[spec.length];
        for (int i = 0; i < spec.length; i++)
            arr[i] = Long.parseLong(spec[i]);
        return arr;
    }
}
