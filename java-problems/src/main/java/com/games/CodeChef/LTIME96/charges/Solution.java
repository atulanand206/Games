package com.games.CodeChef.LTIME96.charges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        while (t-- > 0) {
            int[] spec = inputIntArray(br);
            int n = spec[0], k = spec[1];
            char[] config = br.readLine().toCharArray();
            int[] queries = inputIntArray(br);
            if (n == 1) {
                for (int i = 0; i < queries.length; i++) System.out.println(0);
                continue;
            }
            int[] state = new int[n];
            for (int i = 1; i < n; i++) {
                state[i] = state[i - 1] + 1;
                if (config[i - 1] == config[i])
                    state[i]++;
            }
            int sum = state[state.length - 1];
            for (int query : queries) {
                if (query == 1) {
                    if (config[0] == config[1]) sum--;
                    else sum++;
                    if (config[0] == '0') config[0] = '1';
                    else config[0] = '0';
//                    System.out.println(config);
                    System.out.println(sum);
                    continue;
                }
                if (query == n) {
                    if (config[n - 1] == config[n - 2]) sum--;
                    else sum++;
                    if (config[n - 1] == '0') config[n - 1] = '1';
                    else config[n - 1] = '0';
//                    System.out.println(config);
                    System.out.println(sum);
                    continue;
                }
                if (config.length > 2 && query > 1 && query < n - 1) {
                    int prev = config[query - 2];
                    int st = config[query - 1];
                    int next = config[query];
                    if (prev == st && st == next) sum -= 2;
                    if (prev != st && st != next) sum += 2;
                    if (st == '1') config[query - 1] = '0';
                    else config[query - 1] = '1';
//                System.out.println(config);
                    System.out.println(sum);
                }
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
