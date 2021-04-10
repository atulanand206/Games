package com.games.CodeForces.almostRectangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    static class Pair {
        private int x;
        private int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        static Pair of(int x, int y) {
            return new Pair(x, y);
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[][] ar = new String[n][n];
            List<Pair> points = new ArrayList<>();
            for (int i = 0; i < n; i++) ar[i] = br.readLine().split("");
            for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) if (ar[i][j].equals("*")) points.add(Pair.of(i, j));
            Pair p1 = points.get(0), p2 = points.get(1);
            if (p1.x != p2.x && p1.y != p2.y) {
                ar[p1.x][p2.y] = "*";
                ar[p2.x][p1.y] = "*";
            }
            if (p1.x == p2.x && p1.y != p2.y) {
                int m;
                if (p1.x == 0) m = 1;
                else m = p1.x - 1;
                ar[m][p1.y] = "*";
                ar[m][p2.y] = "*";
            }
            if (p1.x != p2.x && p1.y == p2.y) {
                int m;
                if (p1.y == 0) m = 1;
                else m = p1.y - 1;
                ar[p1.x][m] = "*";
                ar[p2.x][m] = "*";
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(ar[i][j]);
                }
                sb.append("\n");
            }
            System.out.print(sb);
        }
    }
}
