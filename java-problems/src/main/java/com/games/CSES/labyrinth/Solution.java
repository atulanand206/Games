package com.games.CSES.labyrinth;

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

        @Override
        public String toString() {
            return "{" + f + ", " + s + "} -->  ";
        }
    }

    private static final int[][] directions =
            new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] spec = br.readLine().split(" ");
        int n = Integer.parseInt(spec[0]);
        int m = Integer.parseInt(spec[1]);

        char[][] map = new char[n][];
        for (int i = 0; i < n; i++) map[i] = br.readLine().toCharArray();

        Pair a = findChar(map, n, m, 'A');
        Pair b = findChar(map, n, m, 'B');

        boolean[][] vis = new boolean[n][m];
        int[][] dis = getDistances(n, m);

        if (a != null && b != null) {
            dis[a.f][a.s] = 0;
            bfs(map, a.f, a.s, vis, dis);
            if (dis[b.f][b.s] == Integer.MAX_VALUE) {
                System.out.println("NO");
                return;
            }
            System.out.println("YES");
            String sb = shortestPath(dis, b);
            System.out.println(sb.length());
            System.out.println(sb);
        }
    }

    private static int[][] getDistances(int n, int m) {
        int[][] dis = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                dis[i][j] = Integer.MAX_VALUE;
        return dis;
    }

    private static Pair findChar(char[][] map, int n, int m, char ch) {
        for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) if (map[i][j] == ch) return Pair.of(i, j);
        return null;
    }

    private static void bfs(char[][] map,
                            int x, int y,
                            boolean[][] visited, int[][] dis) {
        Stack<Pair> stk = new Stack<>();
        stk.push(Pair.of(x, y));
        visited[x][y] = true;
        while (!stk.isEmpty()) {
            Pair pnt = stk.pop();
            int f = pnt.f;
            int s = pnt.s;
            for (int[] direction : directions) {
                int nx = f + direction[0];
                int ny = s + direction[1];
                if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[nx].length) {
                    if (map[nx][ny] == '#') {
                        visited[nx][ny] = true;
                        continue;
                    }
                    if (dis[f][s] + 1 < dis[nx][ny] && (map[nx][ny] == 'B' || map[nx][ny] == '.')) {
                        dis[nx][ny] = dis[f][s] + 1;
                        visited[nx][ny] = true;
                        if (map[nx][ny] == '.') stk.push(Pair.of(nx, ny));
                    }
                }
            }
        }
    }

    private static String shortestPath(int[][] dis, Pair b) {
        StringBuilder sb = new StringBuilder();
        int f = b.f;
        int s = b.s;
        int d;
        boolean[][] vis = new boolean[dis.length][dis[0].length];
        while ((d = dis[f][s]) != 0) {
            for (int[] direction : directions) {
                int nx = f + direction[0];
                int ny = s + direction[1];
                if (nx >= 0 && nx < dis.length && ny >= 0 && ny < dis[nx].length && !vis[nx][ny]) {
                    vis[nx][ny] = true;
                    if (dis[nx][ny] == d - 1) {
                        sb.append(getDirection(direction));
                        f = nx;
                        s = ny;
                        break;
                    }
                }
            }
        }
        return sb.reverse().toString();
    }


    private static String getDirection(int[] direction) {
        if (direction[0] == 1 && direction[1] == 0) return "U";
        if (direction[0] == -1 && direction[1] == 0) return "D";
        if (direction[0] == 0 && direction[1] == 1) return "L";
        if (direction[0] == 0 && direction[1] == -1) return "R";
        return null;
    }
}
