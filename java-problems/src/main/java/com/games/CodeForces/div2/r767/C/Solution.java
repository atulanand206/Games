package com.games.CodeForces.div2.r767.C;

import com.games.utils.I;
import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.PriorityQueue;

/**
 * Problem: CodeForces 1629C
 *
 * @author atulanand
 */
public class Solution {

    public static String solve(int[] A) {
        PriorityQueue<Integer> smallest = new PriorityQueue<>();
        for (int i : A) smallest.add(i);
        StringBuilder sb = new StringBuilder();
        int aboveMax = maxPlusOne(A);

        return "NO";
    }

    private static int maxPlusOne(int[] a) {
        int cnt = 0;
        for (int i : a) cnt = Math.max(cnt, i);
        return cnt + 1;
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            inputInt(br);
            int[] y = inputIntArray(br);
            sb.append(solve(y)).append("\n");
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
