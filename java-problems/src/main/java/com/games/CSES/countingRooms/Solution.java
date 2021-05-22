package com.games.CSES.countingRooms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {

    private static class Pair {
        int f, s;

        Pair(int x, int s) {
            this.f = x;
            this.s = s;
        }

        static Pair of(int f, int s) {
            return new Pair(f, s);
        }

        public int getF() {
            return f;
        }

        public int getS() {
            return s;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "f=" + f +
                    ", s=" + s +
                    '}';
        }
    }

    private static final int[][] directions =
            new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private static void dfs(char[][] floor, int x, int y, boolean[][] visited) {
        Stack<Pair> stk = new Stack<>();
        stk.push(Pair.of(x, y));
        visited[x][y] = true;
        while (!stk.isEmpty()) {
            Pair pnt = stk.pop();
            for (int[] direction : directions) {
                int nx = pnt.f + direction[0];
                int ny = pnt.s + direction[1];
                if (nx >= 0 && nx < floor.length && ny >= 0 && ny < floor[nx].length) {
                    if (floor[nx][ny] == '#') {
                        visited[nx][ny] = true;
                        continue;
                    }
                    if (floor[nx][ny] == '.' && !visited[nx][ny]) {
                        stk.push(Pair.of(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] spec = br.readLine().split(" ");
        int n = Integer.parseInt(spec[0]);
        int m = Integer.parseInt(spec[1]);
        char[][] floor = new char[n][];
        for (int i = 0; i < n; i++) floor[i] = br.readLine().toCharArray();
        int count = 0;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (floor[i][j] == '#') {
                    visited[i][j] = true;
                    continue;
                }
                if (!visited[i][j]) {
                    count++;
                    dfs(floor, i, j, visited);
                }
            }
        }
        System.out.println(count);
    }
}
