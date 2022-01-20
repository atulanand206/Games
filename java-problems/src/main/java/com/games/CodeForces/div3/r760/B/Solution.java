package com.games.CodeForces.div3.r760.B;

import com.games.utils.I;
import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Problem: CodeForces 1618B
 *
 * @author atulanand
 */
public class Solution {

    public static String solve(String[] strings) {
        int idx = strings.length - 1;
        for (int i = 1; i + 1 < strings.length; i++) {
            if (strings[i].charAt(0) == strings[i].charAt(1)) {
                if (strings[i - 1].charAt(1) != strings[i].charAt(0) || strings[i].charAt(0) != strings[i + 1].charAt(0)){
                    idx = i;
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            sb.append(strings[i].charAt(0));
            if (i == idx) sb.append(strings[idx].charAt(1));
        }
        sb.append('a');
        return sb.toString();
    }

    // Check if a string is just one string repeated twice.
    public static boolean solve2(String s) {
        int k = s.length() / 2;
        return s.substring(0, k).equals(s.substring(k));
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int x = inputInt(br);
            String[] strings = br.readLine().split(" ");
            sb.append(solve(strings)).append("\n");
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
