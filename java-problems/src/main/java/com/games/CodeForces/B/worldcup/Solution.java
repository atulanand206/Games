package com.games.CodeForces.B.worldcup;

import com.games.utils.I;
import com.games.utils.O;
import com.games.utils.S;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Problem: CodeForces 996B
 *
 * @author atulanand
 */
public class Solution {

    public static int solve(long[] arr) {
        long low = 0, high = LongStream.of(arr).sum();
        long ans = high;
        int entry = 0;
        while (low <= high) {
            long mid = (low + high) / 2;
            int entrance = turns(arr, mid);
            if (entrance >= 0 && entrance < arr.length && arr[entrance] < mid) {
                ans = Math.min(ans, mid);
                entry = entrance + 1;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return entry;
    }

    private static int turns(long[] arr, long turn) {
        if (turn % arr.length == 0) {
            return arr.length - 1;
        }
        return (int) (turn % arr.length - 1);
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
//        while (t-- > 0) {
//            sb.append(solve(inputInt(br)));
//        }
        inputInt(br);
        sb.append(solve(inputLongArray(br)));
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
