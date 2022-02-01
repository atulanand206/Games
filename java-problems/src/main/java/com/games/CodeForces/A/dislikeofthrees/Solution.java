package com.games.CodeForces.A.dislikeofthrees;

import com.games.utils.I;
import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Problem: CodeForces 1560A
 *
 * @author atulanand
 */
public class Solution {

    public static int[] solve(int k) {
        int[] ints = new int[k];
        int i = 0;
        int j = 1;
        while (i < ints.length) {
            if (j % 3 == 0 || j % 10 == 3) {
                j++;
                continue;
            }
            ints[i++] = j;
            j++;
        }
        return ints;
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        int[] k = solve(1000);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            sb.append(k[inputInt(br) - 1]).append("\n");
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
