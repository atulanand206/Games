package com.games.CodeChef.Jun21B.minimumDualArea;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(I.inputStream());
        int t = I.inputInt(br);
        O.attach();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = I.inputInt(br);
            List<List<Integer>> pts = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int[] ints = I.inputIntArray(br);
                List<Integer> list = new ArrayList<>();
                list.add(ints[0]);
                list.add(ints[1]);
                pts.add(list);
            }
            pts.sort((o1, o2) -> {
                if (o1.get(0).equals(o2.get(0))) return o1.get(1).compareTo(o2.get(1));
                return o1.get(0).compareTo(o2.get(0));
            });
            for (int i = 1; i < pts.size(); i++) {
                if (pts.get(i).get(0).equals(pts.get(i - 1).get(0)) && pts.get(i).get(1).equals(pts.get(i - 1).get(1)))
                    pts.remove(i--);
            }
            sb.append(minArea(pts)).append("\n");
        }
        O.print(sb);
    }

    private static long minArea(List<List<Integer>> pts) {
        long minArea = Long.MAX_VALUE;

        pts.sort((o1, o2) -> {
            if (o1.get(0).equals(o2.get(0))) return o1.get(1).compareTo(o2.get(1));
            return o1.get(0).compareTo(o2.get(0));
        });
        minArea = minArea(pts, minArea);

        pts.sort((o1, o2) -> {
            if (o1.get(0).equals(o2.get(0))) return o2.get(1).compareTo(o1.get(1));
            return o1.get(0).compareTo(o2.get(0));
        });
        minArea = minArea(pts, minArea);

        pts.sort((o1, o2) -> {
            if (o1.get(1).equals(o2.get(1))) return o1.get(0).compareTo(o2.get(0));
            return o1.get(1).compareTo(o2.get(1));
        });
        minArea = minArea(pts, minArea);

        pts.sort((o1, o2) -> {
            if (o1.get(1).equals(o2.get(1))) return o2.get(0).compareTo(o1.get(0));
            return o1.get(1).compareTo(o2.get(1));
        });
        minArea = minArea(pts, minArea);
        return minArea;
    }

    private static long minArea(List<List<Integer>> pts, long minArea) {
        Rectangle first = new Rectangle();
        for (List<Integer> pt : pts) {
            first.addPoint(pt.get(0), pt.get(1));
        }
        Rectangle second = new Rectangle();
        for (List<Integer> pt : pts) {
            first.removePoint(pt.get(0), pt.get(1));
            second.addPoint(pt.get(0), pt.get(1));
            minArea = Math.min(minArea, first.area() + second.area());
        }
        return minArea;
    }

    private static class Rectangle {
        private final PriorityQueue<Integer> minX = new PriorityQueue<>();
        private final PriorityQueue<Integer> maxX = new PriorityQueue<>(Comparator.reverseOrder());
        private final PriorityQueue<Integer> minY = new PriorityQueue<>();
        private final PriorityQueue<Integer> maxY = new PriorityQueue<>(Comparator.reverseOrder());

        void addPoint(int x, int y) {
            minX.add(x);
            maxX.add(x);
            minY.add(y);
            maxY.add(y);
        }

        void removePoint(int x, int y) {
            minX.remove(x);
            maxX.remove(x);
            minY.remove(y);
            maxY.remove(y);
        }

        long area() {
            long x = 0, y = 0;
            if (!minX.isEmpty() && !maxX.isEmpty()) x = maxX.peek() - minX.peek();
            if (!minY.isEmpty() && !maxY.isEmpty()) y = maxY.peek() - minY.peek();
            return x * y;
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

        private static InputStreamReader inputStream() throws IOException {
            return ("why in the world not?".equals(System.getenv("LOCAL_CODING")))
                    ? fileInputStream() : stdInputStream();
        }

        private static InputStreamReader stdInputStream() {
            return new InputStreamReader(System.in);
        }

        private static InputStreamReader fileInputStream() throws FileNotFoundException {
            return new InputStreamReader(new FileInputStream("input.txt"), StandardCharsets.UTF_8);
        }
    }

    public static class O {

        public static void attach() {
            debug("", false);
        }

        public static void debugNewLine() {
            debug("\n");
        }

        public static void debug(int val) {
            debug(String.valueOf(val));
            debugNewLine();
        }

        public static void debug(long val) {
            debug(String.valueOf(val));
            debugNewLine();
        }

        public static void debug(boolean val) {
            debug(val ? "T" : "F");
            debugNewLine();
        }

        public static void debug(String text) {
            debug(text, true);
        }

        public static void debug(String text, boolean append) {
            if (!"why in the world not?".equals(System.getenv("LOCAL_CODING"))) return;
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

        public static <T> String stringi(List<T> list) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) sb.append(i).append(": ").append(list.get(i)).append("\n");
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
}
