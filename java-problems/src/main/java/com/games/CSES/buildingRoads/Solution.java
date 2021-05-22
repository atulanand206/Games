package com.games.CSES.buildingRoads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    static boolean[] vis;
    static List<Integer> color;
    static List<List<Integer>> adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] spec = br.readLine().split(" ");
        int n = Integer.parseInt(spec[0]);
        int m = Integer.parseInt(spec[1]);
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        while (m-- > 0) {
            String[] road = br.readLine().split(" ");
            int a = Integer.parseInt(road[0]) - 1;
            int b = Integer.parseInt(road[1]) - 1;
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        minSwapsCouples();
        Map<Integer, List<Integer>> map = getCycles();
        List<Integer> singles = map.getOrDefault(-1, new ArrayList<>());
        map.remove(-1);
        int newRoads = map.size() - 1 + singles.size();
        List<Map.Entry<Integer, List<Integer>>> entries = new ArrayList<>(map.entrySet());
        StringBuilder sb = new StringBuilder();
        if (!singles.isEmpty() && !map.isEmpty()) {
            sb.append(singles.get(0) + 1).append(" ").append(entries.get(0).getValue().get(0) + 1).append("\n");
        }
        if (singles.size() > 1) {
            for (int k = 1; k < singles.size(); k++) {
                sb.append(singles.get(0) + 1).append(" ").append(singles.get(k) + 1).append("\n");
            }
        }
        for (int i = 0; i < entries.size() - 1; i++) {
            sb.append(entries.get(i).getValue().get(0) + 1).append(" ").append(entries.get(i + 1).getValue().get(0) + 1).append("\n");
        }
        System.out.println(newRoads);
        System.out.println(sb);
    }

    private static Map<Integer, List<Integer>> getCycles() {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < color.size(); i++) {
            Integer key = color.get(i);
            if (!map.containsKey(key)) {
                List<Integer> places = new ArrayList<>();
                places.add(i);
                map.put(key, places);
            } else {
                List<Integer> integers = map.get(key);
                integers.add(i);
                map.put(key, integers);
            }
        }
        return map;
    }

    public static void minSwapsCouples() {
        vis = new boolean[adj.size()];
        color = new ArrayList<>();
        for (int i = 0; i < adj.size(); i++) color.add(-1);
        int clr = 0;
        for (int i = 0; i < adj.size(); i++) {
            dfs(i, clr++);
        }
    }

    private static void dfs(int i, int clr) {
        for (int j : adj.get(i)) {
            if (!vis[j]) {
                vis[j] = true;
                color.set(j, clr);
                dfs(j, clr);
            }
        }
    }
}