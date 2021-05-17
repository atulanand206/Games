package com.games.CF.May21C.treeHouse;

import com.games.chess.utils.ListUtils;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    private static void write(String text) {
        try {
            FileWriter fileWriter = new FileWriter("debug.txt", true);
            fileWriter.write(text);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int inputInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static int[] inputIntArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split(" ");
        int[] arr = new int[spec.length];
        for (int i = 0; i < spec.length; i++) arr[i] = Integer.parseInt(spec[i]);
        return arr;
    }

    private static final int MOD = (int) (1E9 + 7);

    private static List<List<Integer>> matrix;
    private static List<Long> subValue, value;
    private static List<Pair> edges;

    private static void reset(int n) {
        matrix = new ArrayList<>();
        subValue = new ArrayList<>();
        value = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            matrix.add(new ArrayList<>());
            subValue.add(1L);
            value.add(0L);
        }
        edges = new ArrayList<>();
    }

    private static void dfs() {
        dfs(0, -1);
    }

    private static void dfs(int curr, int last) {
        for (int i : matrix.get(curr)) {
            if (i == last) continue;
            dfs(i, curr);
        }
        edges.clear();
        for (int x : matrix.get(curr)) {
            if (x != last) edges.add(Pair.of(subValue.get(x), x));
        }
        edges.sort(Comparator.comparing(Pair::getF).thenComparing(Pair::getS));

        Collections.reverse(edges);
        long tok = 1;
        for (Pair p : edges) value.set((int) p.s, tok++);
        for (int x : matrix.get(curr))
            if (x != last)
                subValue.set(curr, subValue.get(curr) + value.get(x) * subValue.get(x));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        while (t-- > 0) {
            int[] spec = inputIntArray(br);
            int n = spec[0], x = spec[1];
            reset(n);
            for (int i = 1; i < n; i++) {
                int[] edge = inputIntArray(br);
                edge[0]--; edge[1]--;
                matrix.get(edge[0]).add(edge[1]);
                matrix.get(edge[1]).add(edge[0]);
            }
            dfs();
            System.out.println(((subValue.get(0) % MOD) * (x % MOD)) % MOD);
        }
    }

    private static class Pair {
        long f, s;

        Pair(long x, long s) {
            this.f = x;
            this.s = s;
        }

        static Pair of(long f, long s) {
            return new Pair(f, s);
        }

        public long getF() {
            return f;
        }

        public long getS() {
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

    private static class Node {
        int value;
        int childCount;
        long score;
        Set<Node> children = new HashSet<>();

        Node(int value) {
            this.value = value;
        }

        Node findNode(int value) {
            write(this.value + "\n");
            if (this.value == value) return this;
            for (Node node : children) {
                Node cNode = node.findNode(value);
                if (cNode != null) return cNode;
            }
            return null;
        }

        void addChild(int value) {
            children.add(new Node(value));
        }

        int childrenCount() {
            if (children.isEmpty()) return 0;
            int count = children.size();
            for (Node node : children) count += node.childrenCount();
            childCount = count;
            return childCount;
        }

        void sortChildren() {
            this.children = this.children.stream().sorted((o1, o2) ->
                    Integer.compare(o2.childCount, o1.childCount))
                    .collect(Collectors.toCollection(LinkedHashSet::new));
            for (Node node : children) node.sortChildren();
        }

        void assignScore(int score) {
            this.score = score;
            int sc = score;
            for (Node node : children) {
                node.assignScore((int) (sc % MOD));
                sc = (int) ((sc + score) % MOD);
            }
        }

        long sumOfScores() {
            long score = this.score;
            for (Node node : children)
                score = (score + node.sumOfScores()) % MOD;
            return score;
        }

        void print() {
            write(String.format("(%d: s - %d), ", value, score));
            for (Node node : children) node.print();
            write("\n");
        }
    }

    private static void nodeClass(BufferedReader br, int n, int x) throws IOException {
        Node root = new Node(1);
        root.print();
        write("\n");
        for (int i = 1; i < n; i++) {
            int[] edge = inputIntArray(br);
            Node node = root.findNode(edge[0]);
            if (node != null) node.addChild(edge[1]);
        }
        root.childrenCount();
        root.sortChildren();
        root.assignScore(x);
        root.print();
        write("\n");
        System.out.println(root.sumOfScores());
    }
}