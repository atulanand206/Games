package com.games.CF.helpTheCruiseShip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CodeChef {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine().trim());
        int[] b = intArray(br.readLine());
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i : b) countMap.merge(i, 1, Integer::sum);
        Map<Integer, Integer> typeMap = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) typeMap.merge(entry.getValue(), 1, Integer::sum);
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : typeMap.entrySet())
            if (entry.getValue() >= a && entry.getKey() > res) res = entry.getKey();
        System.out.println(res);
    }

    private static int[] intArray(String num) {
        String[] chars = num.split(" ");
        int[] ints = new int[chars.length];
        for (int i = 0; i < chars.length; i++)
            ints[i] = Integer.parseInt(chars[i]);
        return ints;
    }
}
