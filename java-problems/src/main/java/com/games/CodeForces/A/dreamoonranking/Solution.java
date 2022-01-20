package com.games.CodeForces.A.dreamoonranking;

import com.games.utils.I;
import com.games.utils.O;
import com.games.utils.S;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: CodeForces 1330A
 *
 * @author atulanand
 */
public class Solution {

    public static int solve(int[] A, int k) {
        Arrays.sort(A);
        List<Integer> list = new ArrayList<>();
        for (int i : A) if (!list.contains(i)) list.add(i);
        int i = 0;
        while (k > 0 && i < list.size()) {
            if (list.get(i) != i + 1) {
                list.add(i, i + 1);
                k--;
            }
            i++;
        }
        while (k-- > 0) {
            list.add(list.size() + 1);
        }
        for (i = 0; i < list.size(); i++)
            if (i + 1 != list.get(i))
                return i;
        return list.size();
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int[] k = inputIntArray(br);
            int[] grow = inputIntArray(br);
            sb.append(solve(grow, k[1])).append("\n");
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
