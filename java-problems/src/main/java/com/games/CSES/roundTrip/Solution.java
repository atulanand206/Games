package com.games.CSES.roundTrip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    static List<List<Integer>> adj;
    static int[] dis;
    static boolean[] vis;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] spec = br.readLine().split(" ");
        int n = Integer.parseInt(spec[0]);
        int m = Integer.parseInt(spec[1]);
        adj = new ArrayList<>();
        while (n-- > 0) adj.add(new ArrayList<>());
        while (m-- > 0) {
            spec = br.readLine().split(" ");
            int a = Integer.parseInt(spec[0]) - 1;
            int b = Integer.parseInt(spec[1]) - 1;
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        dis = new int[adj.size()];
        Arrays.fill(dis, Integer.MAX_VALUE);
        parent  = new int[adj.size()];
        parent[0] = -1;
        vis = new boolean[adj.size()];
        dfs(0, 1);
    }

    private static void dfs(int start, int length) {

    }
}
