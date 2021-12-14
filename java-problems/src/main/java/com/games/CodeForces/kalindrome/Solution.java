package com.games.CodeForces.kalindrome;

import com.games.utils.I;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Problem: CodeForces 1610B
 *
 * @author atulanand
 */
public class Solution {

    private static final int MOD = (int) 1E9 + 7;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(I.reader(true));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = inputInt(br);
            int[] q = inputIntArray(br);
            if (n < 3) {
                sb.append("YES").append("\n");
                continue;
            }
            int s = 0;
            int e = n - 1;
            int x = -1;
            while (s < e) {
                if (q[s] == q[e]) {
                    s++;
                    e--;
                } else {
                    break;
                }
            }
            int lx = q[s];
            int rx = q[e];
            int ly = q[s];
            int ry = q[e];


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
