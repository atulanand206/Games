package com.games.CF.minimumPopping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        while (t-- > 0) {
            int[] spec = inputIntArray(br);
            int n = spec[0], m = spec[1];
            int[] nums = inputIntArray(br);
            boolean[] v = new boolean[m];
            Map<Integer, Integer> first = new HashMap<>();
            Map<Integer, Integer> secnd = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (!first.containsKey(nums[i])) {
                    v[i] = true;
                    first.put(nums[i], i);
                }
            }
            for (int i = nums.length - 1; i >= 0; i--) {
                if (!secnd.containsKey(nums[i])) {
                    v[i] = true;
                    secnd.put(nums[i], i);
                }
            }
            for (int i = 0; i < v.length; i++) {
                System.out.printf("%d %s ", i, String.valueOf(v[i]));
            }
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
