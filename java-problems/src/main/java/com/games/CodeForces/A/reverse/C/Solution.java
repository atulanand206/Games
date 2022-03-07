package com.games.CodeForces.A.reverse.C;

import com.games.utils.I;
import com.games.utils.O;
import com.games.utils.S;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Problem: CodeForces 1638A
 *
 * @author atulanand
 */

class Solution {

    public static String solve(int[] arr) {
        int i = 0;
        while (i < arr.length && arr[i] == i + 1) {
            i++;
        }
        if (i != arr.length) {
            int j = i + 1;
            while (j < arr.length && arr[j] != i + 1) {
                j++;
            }
            while (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        return string(arr);
    }

    private static String string(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int i : a) {
            sb.append(i).append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = inputInt(br);
            int[] specs = inputIntArray(br);
            sb.append(solve(specs)).append("\n");
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

    public static long[] inputLongArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split(" ");
        long[] arr = new long[spec.length];
        for (int i = 0; i < spec.length; i++)
            arr[i] = Long.parseLong(spec[i]);
        return arr;
    }
}
