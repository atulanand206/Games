package com.games.CodeForces.makeProductEqualOne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = inputInt(br);
        int[] spec = inputIntArray(br);
        long negs = 0, pos = 0, neg = 0, zer = 0;
        for (int i : spec) {
            if (i < 0) negs++;
            if (i > 0) pos += Math.abs(i - 1);
            if (i < 0) neg += Math.abs(i + 1);
            if (i == 0) zer++;
        }
        if (negs % 2 != 0) if (zer == 0) neg += 2;
        System.out.println(pos + neg + zer);
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
}
