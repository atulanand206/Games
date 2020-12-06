package com.games.UVa.P102;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        Main main = new Main();
        while ((line = br.readLine()) != null) {
            final String[] items = line.split(" ");
            System.out.println(main.binPacking(items));
        }
    }

    private String[] types = {"B", "G", "C"};
    private int[][] permutations = {
            {0, 1, 2},
            {0, 2, 1},
            {1, 0, 2},
            {1, 2, 0},
            {2, 0, 1},
            {2, 1, 0}
    };

    String binPacking(String[] items) {

        int[][] bins = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                bins[i][j] = Integer.parseInt(items[3 * i + j]);
            }
        }
        int minCount = -1;
        String minConfig = "";
        for (int[] permutation : permutations) {
            int count = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (permutation[i] != j) {
                        count += bins[i][j];
                    }
                }
            }
            String config = types[permutation[0]] + types[permutation[1]] + types[permutation[2]];
            if (minCount == -1 || count < minCount || (count == minCount && config.compareTo(minConfig) < 0)) {
                minCount = count;
                minConfig = config;
            }
        }
        return minConfig + " " + minCount;
    }
}
