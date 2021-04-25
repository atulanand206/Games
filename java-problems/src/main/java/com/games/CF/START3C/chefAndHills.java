package com.games.CF.START3C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class chefAndHills {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        while (t-- > 0) {
            int[] spec = inputIntArray(br);
            int n = spec[0], k = spec[1];
            int[] houses = inputIntArray(br);
            int s1 = houses[n / 2] - k / 2;
            int s2 = s1;
            if (n / 2 > 0)
                s2 = houses[n / 2 - 1] - k / 2;
            int min = Integer.MAX_VALUE;
            for (int h : new int[]{s1, s2}) {
                int end = h + k - 1;
                int dist = 0;
                for (int i : houses) dist += Math.max(Math.abs(h - i), Math.abs(end - i));
                min = Math.min(min, dist);
            }
            System.out.println(min);
        }
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
