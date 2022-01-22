package com.games.CodeForces.A.escapefromstones;

import com.games.utils.I;
import com.games.utils.O;
import com.games.utils.S;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

/**
 * Problem: CodeForces 264A
 *
 * @author atulanand
 */
public class Solution {

    public static String solveBF(char[] A) {
        Map<Double, Integer> map = new HashMap<>();
        double s = 0, e = Math.pow(2, 50);
        for (int i = 0; i < A.length; i++) {
            double d = (e - s) / 2;
            map.put((s + d), i + 1);
            if (A[i] == 'l') e -= d;
            else s += d;
        }
        O.debug(S.string(map));
        return map.entrySet()
                .stream()
                .sorted(Comparator.comparingDouble(Map.Entry::getKey))
                .map(Map.Entry::getValue)
                .map(String::valueOf)
                .reduce("", (a, b) -> a.equals("") ? b : a + "\n" + b);
    }

    public static String solve(char[] A) {
        List<Integer> v1 = new ArrayList<>();
        List<Integer> v2 = new ArrayList<>();
        for (int i = 0; i < A.length; i++)
            if (A[i] == 'r') v1.add(i + 1);
            else v2.add(i + 1);
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < v1.size(); j++) sb.append(v1.get(j)).append('\n');
        for (int j = v2.size() - 1; j >= 0; j--) sb.append(v2.get(j)).append('\n');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 1;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            sb.append(solve(inputCharArray(br)));
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
