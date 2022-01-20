package com.games.CodeForces.div3.r764.A;

import com.games.utils.I;
import com.games.utils.O;
import com.games.utils.S;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Problem: CodeForces 1624A
 *
 * @author atulanand
 */
public class Solution {

    public static long solve(long[] arr) {
        if (arr.length == 1) return 0;
        Arrays.sort(arr);
        if (arr[0] == arr[arr.length - 1]) return 0;
        int ctr = 0;
        long ans = 0;
        while ((ctr = extracted(arr)) != -1) {
            long diff = arr[ctr + 1] - arr[ctr];
            ans += diff;
            for (int i = 0; i <= ctr; i++) arr[i] += diff;
        }
        return ans;
    }

    private static int extracted(long[] arr) {
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] != arr[i + 1]) return i;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            inputInt(br);
            long[] x = inputLongArray(br);
            sb.append(solve(x)).append("\n");
        }
        System.out.println(sb);
    }

    public static int inputInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine().trim());
    }

    public static long[] inputLongArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split(" ");
        long[] arr = new long[spec.length];
        for (int i = 0; i < spec.length; i++)
            arr[i] = Long.parseLong(spec[i]);
        return arr;
    }
}
