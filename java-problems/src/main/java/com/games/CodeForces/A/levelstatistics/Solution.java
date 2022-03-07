package com.games.CodeForces.A.levelstatistics;

import com.games.utils.I;
import com.games.utils.O;
import com.games.utils.S;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Problem: CF 1334A
 *
 * @author atulanand
 */

public class Solution {
    static class Result {
        public int solve(int[][] stats) {
            int plays = 0, clears = 0;
            for (int[] stat : stats) {
                int nextPlays = stat[0];
                int nextClears = stat[1];
                int diffPlays = nextPlays - plays;
                int diffClears = nextClears - clears;
                if (nextClears > nextPlays || nextPlays < plays || nextClears < clears || diffClears > diffPlays) {
                    return 0;
                }
                plays = nextPlays;
                clears = nextClears;
            }
            return 1;
        }
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = inputInt(br);
            int[][] stats = new int[n][];
            for (int i = 0; i < n; i++) {
                stats[i] = inputIntArray(br);
            }
            if (t == 0)
            O.debug(S.string(stats));
            sb.append(new Result().solve(stats) == 1 ? "Yes" : "No").append("\n");
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
