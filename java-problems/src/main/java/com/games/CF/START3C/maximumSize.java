package com.games.CF.START3C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class maximumSize {

    static class Pt {
        int x, y;

        Pt(int x, int y) {
            this.x = x;
            this.y = y;
        }

        static Pt of(int x, int y) {
            return new Pt(x, y);
        }
    }

    private static int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] spec = br.readLine().split(" ");
            int n = Integer.parseInt(spec[0]), m = Integer.parseInt(spec[1]);
            String[][] arr = new String[n][m];
            for (int i = 0; i < n; i++) {
                arr[i] = br.readLine().split("");
            }
            boolean[][] vis = new boolean[n][m];
            PriorityQueue<Integer> counts = new PriorityQueue<>(Comparator.reverseOrder());
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j].equals("0")) continue;
                    if (vis[i][j]) continue;
                    int count = 0;
                    Stack<Pt> pnts = new Stack<>();
                    pnts.add(Pt.of(i, j));
                    while (!pnts.isEmpty()) {
                        Pt pt = pnts.pop();
                        vis[pt.x][pt.y] = true;
                        count++;
                        for (int[] direction : directions) {
                            int x1 = pt.x + direction[0];
                            int y1 = pt.y + direction[1];
                            if (x1 < 0 || x1 >= n || y1 < 0 || y1 >= m) continue;
                            if (!vis[x1][y1] && arr[x1][y1].equals("1")) {
                                vis[x1][y1] = true;
                                arr[x1][y1] = "0";
                                pnts.add(Pt.of(x1, y1));
                            }
                        }
                    }
                    counts.add(count);
                }
            }
            int chef = 0;
            while (!counts.isEmpty()) {
                counts.poll();
                if (!counts.isEmpty()) chef += counts.poll();
            }
            System.out.println(chef);
        }
    }// 10 4 3 2 1 1 1 1 1
}


//1111
//0101
//0101
//1011