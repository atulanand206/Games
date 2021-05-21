package com.games.CodeForces.protectSheep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] spec = br.readLine().split(" ");
        int r = Integer.parseInt(spec[0]), c = Integer.parseInt(spec[1]);
        char[][] grid = new char[r][];
        for (int i = 0; i < r; i++) grid[i] = br.readLine().toCharArray();
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                if (grid[i][j] == 'S' && isWolfAround(grid, i, j)) {
                    System.out.println("No");
                    return;
                }
        char w = '.';
        System.out.println("Yes");
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                if (grid[i][j] == 'S') {
                    if (i > 0) if (grid[i - 1][j] == w) grid[i - 1][j] = 'D';
                    if (j > 0) if (grid[i][j - 1] == w) grid[i][j - 1] = 'D';
                    if (i < grid.length - 1) if (grid[i + 1][j] == w) grid[i + 1][j] = 'D';
                    if (j < grid[i].length - 1) if (grid[i][j + 1] == w) grid[i][j + 1] = 'D';
                }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean isWolfAround(char[][] grid, int x, int y) {
        char w = 'W';
        if (x > 0) if (grid[x - 1][y] == w) return true;
        if (y > 0) if (grid[x][y - 1] == w) return true;
        if (x < grid.length - 1) if (grid[x + 1][y] == w) return true;
        if (y < grid[x].length - 1) return grid[x][y + 1] == w;
        return false;
    }
}
