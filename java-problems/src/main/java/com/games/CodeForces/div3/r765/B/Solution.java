package com.games.CodeForces.div3.r765.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem: CodeForces 1625B
 *
 * @author atulanand
 */
public class Solution {

    // Find the longest harmonious string.
    // Harmonious means matching no at same index.
    // Finding the closest pair creates such pair of strings.
    public static int solve(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                int dis = i - map.get(A[i]);
                if (dis < ans) {
                    ans = dis;
                }
            }
            map.put(A[i], i);
        }
        return ans == Integer.MAX_VALUE ? -1 : A.length - ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            inputInt(br);
            int[] x = inputIntArray(br);
            sb.append(solve(x)).append("\n");
        }
        System.out.println(sb);
    }

    public static int inputInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine().trim());
    }

    public static int[] inputIntArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split(" ");
        int[] arr = new int[spec.length];
        for (int i = 0; i < spec.length; i++)
            arr[i] = Integer.parseInt(spec[i]);
        return arr;
    }
}
