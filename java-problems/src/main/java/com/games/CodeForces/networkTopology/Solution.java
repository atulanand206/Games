package com.games.CodeForces.networkTopology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] spec = br.readLine().split(" ");
        int n = Integer.parseInt(spec[0]);
        int m = Integer.parseInt(spec[1]);
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            spec = br.readLine().split(" ");
            int x = Integer.parseInt(spec[0]) - 1;
            int y = Integer.parseInt(spec[1]) - 1;
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        int ones = 0, twos = 0, all = 0;
        for (int i = 0; i < n; i++) {
            switch (graph.get(i).size()) {
                case 1: ones++; break;
                case 2: twos++; break;
            }
            if (graph.get(i).size() == m) all++;
        }
        if (m == n && twos == n) {
            System.out.print("ring topology");
            return;
        }
        if (m == n - 1) {
            if (all == 1 && ones == m) {
                System.out.println("star topology");
                return;
            }
            if (twos == m - 1 && ones == 2) {
                System.out.println("bus topology");
                return;
            }
        }
        System.out.println("unknown topology");
    }
}
