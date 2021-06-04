package com.games.CodeForces.sushiForTwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = inputInt(br);
        int[] arr = inputIntArray(br);
        List<Integer> consecutive = new ArrayList<>();
        int z = 1;
        for (int i = 1; i < n; i++)
            if (arr[i] == arr[i - 1]) z++;
            else {
                consecutive.add(z);
                z = 1;
            }
        consecutive.add(z);
        int max = 0;
        for (int i = 1; i < consecutive.size(); i++)
            max = Math.max(max, Math.min(consecutive.get(i - 1), consecutive.get(i)));
        System.out.println(2 * max);
    }

    private static int inputInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static int[] inputIntArray(BufferedReader br) throws IOException {
        String[] s = br.readLine().split(" ");
        int[] z = new int[s.length];
        for (int i = 0; i < s.length; i++) z[i] = Integer.parseInt(s[i]);
        return z;
    }
}
