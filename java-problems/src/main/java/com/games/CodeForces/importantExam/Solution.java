package com.games.CodeForces.importantExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] spec = inputIntArray(br);
        int n = spec[0], m = spec[1];
        Map<Integer, List<Character>> answers = new HashMap<>();
        for (int i = 0; i < m; i++) answers.put(i, new ArrayList<>());
        for (int i = 0; i < n; i++) {
            char[] s = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) answers.get(j).add(s[j]);
        }
        List<Integer> pos = new ArrayList<>();
        for (Map.Entry<Integer, List<Character>> entry : answers.entrySet()) {
            List<Character> sorted = entry.getValue().stream().sorted().collect(Collectors.toList());
            int cnt = 1, max = 0;
            for (int i = 1; i < n; i++) {
                if (sorted.get(i).equals(sorted.get(i - 1))) cnt++;
                else {
                    max = Math.max(max, cnt);
                    cnt = 1;
                }
            }
            max = Math.max(max, cnt);
            pos.add(max);
        }
        int[] values = inputIntArray(br);
        long score = 0;
        for (int i = 0; i < m; i++) score += (long) values[i] * pos.get(i);
        System.out.println(score);
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
