package com.games.CF.mayCookOff.q3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        long[] data = new long[60];
        data[0] = 1;
        for (int i = 1; i < data.length; i++) data[i] = data[i - 1] * 2;
        for (int i = 0; i < data.length; i++) data[i]--;
        StringBuilder sv = new StringBuilder();
        while (t-- > 0) {
            long[] spec = inputLongArray(br);
            long x = spec[0], y = spec[1];
            long k = y / x;
            int i = 59;
            List<Integer> res = new ArrayList<>();
            while (i > 0) {
                if (data[i] <= k) {
                    res.add(i);
                    k -= data[i];
                }
                i--;
            }
            long m = 0;
            for (int j : res) m += data[j];
            int ans = 0;
            for (int j : res) ans += j;
            ans += res.size() - 1;
            if (y - x * m == 0) sv.append(ans);
            else sv.append(-1);
            sv.append("\n");
        }
        System.out.println(sv);
    }

    public static int inputInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    public static int[] inputIntArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split(" ");
        int[] arr = new int[spec.length];
        for (int i = 0; i < spec.length; i++) arr[i] = Integer.parseInt(spec[i]);
        return arr;
    }

    public static long inputLong(BufferedReader br) throws IOException {
        return Long.parseLong(br.readLine());
    }

    public static long[] inputLongArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split(" ");
        long[] arr = new long[spec.length];
        for (int i = 0; i < spec.length; i++) arr[i] = Long.parseLong(spec[i]);
        return arr;
    }
}
