package com.games.CodeForces.forbiddensequence;

import com.games.utils.I;
import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Stack;

/**
 * Problem: CodeForces 1494A
 *
 * @author atulanand
 */
public class Solution {

    // lexicographically smallest permutation of A
    // without having seq of length 3 as a subsequence.
    public static String solve(char[] A, char[] seq) {
        int[] freq = frequency(A);
        StringBuilder sb = new StringBuilder();
        add(sb, freq, 0);
        if (sb.length() != 0 && seq[1] == 'b' && seq[0] == 'a') {
            add(sb, freq, 2);
            add(sb, freq, 1);
        } else {
            add(sb, freq, 1);
            add(sb, freq, 2);
        }
        for (int i = 3; i < freq.length; i++)
            add(sb, freq, i);
        return sb.toString();
    }

    private static void add(StringBuilder sb, int[] freq, int i) {
        while (freq[i]-- > 0) sb.append((char) (i + 97));
    }

    private static int[] frequency(char[] chars) {
        int[] freq = new int[26];
        for (char ch : chars) freq[(int) ch - 97]++;
        return freq;
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

    public static int[] inputIntArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split(" ");
        int[] arr = new int[spec.length];
        for (int i = 0; i < spec.length; i++)
            arr[i] = Integer.parseInt(spec[i]);
        return arr;
    }
}
