package com.games.LeetCode.JuneChallenge.OpenTheLock;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] deadEnds = br.readLine()
                .replace("\",\"", " ")
                .replace("[\"", "")
                .replace("\"]", "")
                .split(" ");
        String target = br.readLine();
        O.beginWrite("");
        O.print(new Solution().openLock(deadEnds, target));
    }

    private List<Set<Integer>> adj = new ArrayList<>();
    private List<int[]> names = new ArrayList<>();
    private boolean[] deadEnds;

    private static int n = 10000;
    private static int digits = 4;

    public int openLock(String[] deadends, String target) {
        O.write(S.string(deadends));
        O.write(S.string(target));
        init(n, deadends);
        graph(n);
        O.write(S.stringi(adj));
        return minDist(target);
    }

//    O(V+E) == O(90k)
    private int minDist(String target) {
        boolean[] visited = new boolean[n];
        int[] distances = new int[n];
        Arrays.fill(distances, -1);
        Queue<Integer> q = new LinkedList<>();
        if (!deadEnds[0]) {
            q.add(0);
            distances[0] = 0;
            visited[0] = true;
        }
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int i : adj.get(x)) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                    distances[i] = distances[x] + 1;
                }
            }
        }
        return distances[Integer.parseInt(target)];
    }

    private void graph(int n) {
        for (int i = 0; i < n; i++) { // O(320k)
            if (deadEnds[i]) continue; // O(1)
            int[] from = names.get(i);
            for (int j = 0; j < digits; j++) { // O(16 * 1)
                int[] to = from.clone(); // O(4)
                to[j] = (to[j] + 1) % 10;
                int k = getNode(to); // O(4)
                adj.get(i).add(k);
                if (deadEnds[k]) continue; // O(1)
                adj.get(k).add(i);
            }
            for (int j = 0; j < digits; j++) {
                int[] to = from.clone();
                to[j] = (to[j] + 9) % 10;
                int k = getNode(to);
                adj.get(i).add(k);
                if (deadEnds[k]) continue; // O(1)
                adj.get(k).add(i);
            }
        }
    }

//    O(50k)
    private void init(int n, String[] deadEnds) {
        for (int i = 0; i < n; i++) adj.add(new TreeSet<>());
        for (int i = 0; i < n; i++) names.add(getValue(i));
        this.deadEnds = new boolean[n];
        for (String deadEnd : deadEnds) this.deadEnds[Integer.parseInt(deadEnd)] = true;
    }

//    O(4)
    private int[] getValue(int n) {
        String res = formatted(n);
        char[] resArr = res.toCharArray();
        int[] arr = new int[res.length()];
        for (int j = 0; j < arr.length; j++)
            arr[j] = Integer.parseInt(String.valueOf(resArr[j]));
        return arr;
    }

//    O(4)
    private int getNode(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i : arr) sb.append(i);
        return Integer.parseInt(sb.toString());
    }

    private static String formatted(int i) {
        return String.format("%" + digits + "d", i).replace(" ", "0");
    }

    public static class S {

        public static <T> String string(T val) {
            return val + "\n";
        }

        public static String string(int[] array) {
            StringBuilder sb = new StringBuilder();
            openingBracket(sb);
            for (int in : array) sb.append(in).append(", ");
            if (array.length != 0) deleteLastComma(sb);
            closingBracket(sb);
            return sb.toString();
        }

        public static String string(long[] array) {
            StringBuilder sb = new StringBuilder();
            openingBracket(sb);
            for (long in : array) sb.append(in).append(", ");
            if (array.length != 0) deleteLastComma(sb);
            closingBracket(sb);
            return sb.toString();
        }

        public static String string(double[] array) {
            StringBuilder sb = new StringBuilder();
            openingBracket(sb);
            for (double in : array) sb.append(in).append(", ");
            if (array.length != 0) deleteLastComma(sb);
            closingBracket(sb);
            return sb.toString();
        }

        public static String string(boolean[] array) {
            StringBuilder sb = new StringBuilder();
            openingBracket(sb);
            for (boolean in : array) sb.append(in ? "T" : "F").append(", ");
            if (array.length != 0) deleteLastComma(sb);
            closingBracket(sb);
            return sb.toString();
        }

        public static String string(char[] array) {
            StringBuilder sb = new StringBuilder();
            openingBracket(sb);
            for (char in : array) sb.append(in).append(", ");
            if (array.length != 0) deleteLastComma(sb);
            closingBracket(sb);
            return sb.toString();
        }

        public static String string(String[] array) {
            StringBuilder sb = new StringBuilder();
            openingBracket(sb);
            for (String in : array) sb.append(in).append(", ");
            if (array.length != 0) deleteLastComma(sb);
            closingBracket(sb);
            return sb.toString();
        }

        public static String string(int[][] array) {
            StringBuilder sb = new StringBuilder();
            openingBracketWithNewLine(sb);
            for (int[] in : array) sb.append("  ").append(string(in));
            closingBracket(sb);
            return sb.toString();
        }

        public static String string(long[][] array) {
            StringBuilder sb = new StringBuilder();
            openingBracketWithNewLine(sb);
            for (long[] in : array) sb.append("  ").append(string(in));
            closingBracket(sb);
            return sb.toString();
        }

        public static String string(double[][] array) {
            StringBuilder sb = new StringBuilder();
            openingBracketWithNewLine(sb);
            for (double[] in : array) sb.append("  ").append(string(in));
            closingBracket(sb);
            return sb.toString();
        }

        public static <T> String string(boolean[][] array) {
            StringBuilder sb = new StringBuilder();
            openingBracketWithNewLine(sb);
            for (boolean[] in : array) sb.append("  ").append(string(in));
            closingBracket(sb);
            return sb.toString();
        }

        public static String string(char[][] array) {
            StringBuilder sb = new StringBuilder();
            openingBracketWithNewLine(sb);
            for (char[] in : array) sb.append("  ").append(string(in));
            closingBracket(sb);
            return sb.toString();
        }

        public static String string(String[][] array) {
            StringBuilder sb = new StringBuilder();
            openingBracketWithNewLine(sb);
            for (String[] in : array) sb.append("  ").append(string(in));
            closingBracket(sb);
            return sb.toString();
        }

        public static <T> String stringi(List<Set<Integer>> list) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                sb.append(formatted(i)).append(": [");
                for (int j : list.get(i))
                    sb.append(formatted(j)).append(" ");
//                deleteLastComma(sb);
                sb.append("]\n");
            }
            return sb.toString();
        }

        public static <T> String string(Collection<T> collection) {
            StringBuilder sb = new StringBuilder();
            openingBracket(sb);
            for (T t : collection) sb.append(t).append(", ");
            if (!collection.isEmpty()) deleteLastComma(sb);
            closingBracket(sb);
            return sb.toString();
        }

        public static <T> String string2D(Collection<Collection<T>> collection) {
            StringBuilder sb = new StringBuilder();
            openingBracketWithNewLine(sb);
            for (Collection<T> t : collection) sb.append("  ").append(string(t));
            closingBracket(sb);
            return sb.toString();
        }

        public static <T> String string2Di(List<Collection<T>> list) {
            StringBuilder sb = new StringBuilder();
            openingBracketWithNewLine(sb);
            for (int i = 0; i < list.size(); i++) sb.append("  ").append(i).append(": ").append(string(list.get(i)));
            closingBracket(sb);
            return sb.toString();
        }

        public static <E, V> String string(Map<E, V> map) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<E, V> entry : map.entrySet())
                sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
            sb.append("\n");
            return sb.toString();
        }

        private static void openingBracket(StringBuilder sb) {
            sb.append("[");
        }

        private static void openingBracketWithNewLine(StringBuilder sb) {
            sb.append("[\n");
        }

        private static void closingBracket(StringBuilder sb) {
            sb.append("]\n");
        }

        private static void deleteLastComma(StringBuilder sb) {
            sb.delete(sb.length() - 2, sb.length());
        }
    }

    public static class I {

        public static int inputInt(BufferedReader br) throws IOException {
            return Integer.parseInt(br.readLine());
        }

        public static int[] inputIntArray(BufferedReader br) throws IOException {
            String[] spec = br.readLine().split(" ");
            int[] arr = new int[spec.length];
            for (int i = 0; i < spec.length; i++) arr[i] = Integer.parseInt(spec[i]);
            return arr;
        }

        public static long inputLong(BufferedReader br) throws IOException {
            return Long.parseLong(br.readLine());
        }

        public static long[] inputLongArray(BufferedReader br) throws IOException {
            String[] spec = br.readLine().split(" ");
            long[] arr = new long[spec.length];
            for (int i = 0; i < spec.length; i++) arr[i] = Long.parseLong(spec[i]);
            return arr;
        }

        public static String inputString(BufferedReader br) throws IOException {
            return br.readLine();
        }
    }

    public static class O {

        public static void beginWrite(String text) {
            write(text, false);
        }

        public static void write(String text) {
            write(text, true);
        }

        public static void write(String text, boolean append) {
            try {
                FileWriter fileWriter = new FileWriter("debug.txt", append);
                fileWriter.write(text);
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static <T> void print(T object) {
            System.out.println(object);
        }
    }
}
