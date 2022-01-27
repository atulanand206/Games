package com.games.CodeForces.B.johnyhobbies;

import com.games.utils.I;
import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Problem: CodeForces 1362B
 *
 * @author atulanand
 */
public class Solution {

    public static String solve(int[] A) {
        if (A.length % 2 != 0) return "-1";
        int xor = 0;
        for (int i : A) xor ^= i;
        if (!possible(A, xor)) return "-1";
        if (xor == 0) {
            for (int i = 1; i <= 1024; i++)
                if (possible(A, i)) return String.valueOf(i);
            return "-1";
        }
        return String.valueOf((xor));
    }

    private static boolean possible(int[] A, int xor) {
        Set<Integer> set = new HashSet<>();
        for (int i : A) set.add(i ^ xor);
        for (int i : A) if (!set.contains(i)) return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            inputInt(br);
            sb.append(solve(inputIntArray(br))).append("\n");
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
