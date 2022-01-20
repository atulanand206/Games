package com.games.CodeForces.A.divideandmultiply;

import com.games.utils.I;
import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem: CodeForces 1607A
 *
 * @author atulanand
 */
public class Solution {

    public static long solve(char[] keys, char[] A) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < keys.length; i++) map.put(keys[i], i);
        long sum = 0;
        for (int i = 1; i < A.length; i++)
            sum += Math.abs(map.get(A[i]) - map.get(A[i - 1]));
        return sum;
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            sb.append(solve(inputCharArray(br), inputCharArray(br))).append("\n");
        }
        System.out.println(sb);
    }

    private static char[] inputCharArray(BufferedReader br) throws IOException {
        return br.readLine().trim().toCharArray();
    }

    public static int inputInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine().trim());
    }

    public static long[] inputIntArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split(" ");
        long[] arr = new long[spec.length];
        for (int i = 0; i < spec.length; i++)
            arr[i] = Long.parseLong(spec[i]);
        return arr;
    }
}
