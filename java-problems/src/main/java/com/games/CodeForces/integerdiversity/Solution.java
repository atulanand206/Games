package com.games.CodeForces.integerdiversity;

import com.games.utils.I;
import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Problem: CodeForces 1616A
 *
 * @author atulanand
 */
public class Solution {

    public static int solve(int[] values) {
        int[] freq = new int[101];
        for (int value : values) freq[Math.abs(value)]++;
        if (freq[0] > 0) freq[0] = 1;
        for (int i = 1; i < freq.length; i++) freq[i] = Math.min(freq[i], 2);
        int sum = 0;
        for (int i : freq) sum += i;
        return sum;
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            inputInt(br);
            int[] x = inputIntArray(br);
            sb.append(solve(x)).append("\n");
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
