package com.games.CSES.messageRoute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
        Arrays.fill(dis, Integer.MAX_VALUE - 10);

        parent  = new int[adj.size()];
        parent[0] = -1;
        vis = new boolean[adj.size()];
        bfspQ(0);
//        print(dis);
        if (dis[dis.length - 1] == Integer.MAX_VALUE - 10) System.out.println("IMPOSSIBLE");
        else {
            System.out.println(dis[dis.length - 1] + 1);
            int[] path = path(dis.length - 1);
            for (int j = path.length - 1; j >= 0; j--) System.out.printf("%d ", path[j]);
        }
    }

    private static void print(int[] a) {
        for (int i : a) System.out.printf("%d ", i);
        System.out.println();
    }

    private static class Node {
        int val;
        int dist;

        public Node(int val, int dist) {
            this.val = val;
            this.dist = dist;
        }

        public int getDist() {
            return dist;
        }

        public void setDist(int dist) {
            this.dist = dist;
        }

        @Override
        public String toString() {
            return "{" +
                    "val=" + val +
                    ", dist=" + dist +
                    '}';
        }
    }

    private static void bfspQ(int i) {
        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparing(Node::getDist));
        q.add(new Node(i, 0));
        dis[i] = 0;
        vis[i] = true;
//        System.out.println(q);
        while (!q.isEmpty()) {
            Node t = q.poll();
            for (int j : adj.get(t.val)) {
                if (!vis[j]) {
                    q.add(new Node(j, t.dist + 1));
                    vis[j] = true;
                    dis[j] = t.dist + 1;
                    parent[j] = t.val;
                }
            }
//            System.out.println(q);
        }
    }

    private static void bfs(int i) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        vis[i] = true;
        while (!q.isEmpty()) {
            int t = q.poll();
            for (int j : adj.get(t)) {
                if (!vis[j]) {
                    q.add(j);
                    vis[j] = true;
                    dis[j] = dis[t] + 1;
                    parent[j] = t;
                }
            }
        }
    }

    private static int[] path(int start) {
        int[] pth = new int[dis[start] + 1];
        int k = 0; pth[k++] = start + 1;
        int i = start;
        while (i != 0) {
            i = parent[i];
            pth[k++] = i + 1;
        }
        return pth;
    }
}
