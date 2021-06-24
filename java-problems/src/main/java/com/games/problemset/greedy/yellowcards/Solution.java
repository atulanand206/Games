package com.games.problemset.greedy.yellowcards;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(I.inputStream());
        O.attach();
        int a1 = I.inputInt(br);
        int a2 = I.inputInt(br);
        int k1 = I.inputInt(br);
        int k2 = I.inputInt(br);
        int n = I.inputInt(br);
        int min = mn(a1, a2, k1, k2, n);
        int max = mx(a1, a2, k1, k2, n);
        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(max);
        O.print(sb);
    }

    private static int mn(int a1, int a2, int k1, int k2, int n) {
        p = n;
        int y = a1 + a2;
        if (k1 == k2) {
            make(a1 + a2, k1);
        } else if (k1 < k2) {
            if (k2 > 1)
                a2 -= makeNext(a2, k2 - 1);
            O.debug(p);
            if (a2 > 0 && p > 0) {
                p -= Math.min(p, k1 - 1);
                a1 -= 1;
            }
            O.debug(p);
            if (k1 > 1)
                a1 -= makeNext(a1, k1 - 1);
            if (a1 > 0 && p > 0) {
                p -= Math.min(p, k2 - 1);
                a2 -= 1; 
            }
            O.debug(p);
        } else if (k1 > k2) {
            if (k1 > 1)
                a1 -= makeNext(a1, k1 - 1);
            if (a1 > 0 && p > 0) {
                p -= Math.min(p, k1 - 1);
                a1 -= 1;
            }
            if (k2 > 1)
                a2 -= makeNext(a2, k2 - 1);
            if (a2 > 0 && p > 0) {
                p -= Math.min(p, k2 - 1);
                a2 -= 1; 
            }
        }
        return Math.min(y, p);
    }

    private static int makeNext(int a, int k) {
        int t = 0;
        if (p > 0) {
            t = take(a, k, p);
            if (t > 0) {
                p -= t;
            }
        }
        return t / k;
    }

    private static void make(int a, int k) {
        if (k * a >= p) {
            p = 0;
        } else {
            p -= k * a;
        }
    }

    private static int p;

    private static int mx(int a1, int a2, int k1, int k2, int n) {
        p = n;
        int max = 0;
        if (k1 == k2) {
            max = take(a1 + a2, k1, p) / k1;
        } else if (k1 < k2) {
            max += takeHighest(a1, k1);
            max += takeHighest(a2, k2);
        } else if (k1 > k2) {
            max += takeHighest(a2, k2);
            max += takeHighest(a1, k1);
        }
        return max;
    }

    private static int takeHighest(int a, int k) {
        int t = 0;
        if (p > 0) {
            t = take(a, k, p);
        }
        if (t > 0) {
            p -= t;
            return t / k;
        }
        return 0;
    }

    private static int take(int a, int k, int n) {
        for (int x = a; x >= 0; x--) {
            if (x * k <= n)
                return x * k;
        }
        return 0;
    }

    public static class S {

        public static <T> String string(T val) {
            return val + "\n";
        }

        public static String string(int[] array) {
            StringBuilder sb = new StringBuilder();
            openingBracket(sb);
            for (int in : array)
                sb.append(in).append(", ");
            if (array.length != 0)
                deleteLastComma(sb);
            closingBracket(sb);
            return sb.toString();
        }

        public static String string(long[] array) {
            StringBuilder sb = new StringBuilder();
            openingBracket(sb);
            for (long in : array)
                sb.append(in).append(", ");
            if (array.length != 0)
                deleteLastComma(sb);
            closingBracket(sb);
            return sb.toString();
        }

        public static String string(double[] array) {
            StringBuilder sb = new StringBuilder();
            openingBracket(sb);
            for (double in : array)
                sb.append(in).append(", ");
            if (array.length != 0)
                deleteLastComma(sb);
            closingBracket(sb);
            return sb.toString();
        }

        public static String string(boolean[] array) {
            StringBuilder sb = new StringBuilder();
            openingBracket(sb);
            for (boolean in : array)
                sb.append(in ? "T" : "F").append(", ");
            if (array.length != 0)
                deleteLastComma(sb);
            closingBracket(sb);
            return sb.toString();
        }

        public static String string(char[] array) {
            StringBuilder sb = new StringBuilder();
            openingBracket(sb);
            for (char in : array)
                sb.append(in).append(", ");
            if (array.length != 0)
                deleteLastComma(sb);
            closingBracket(sb);
            return sb.toString();
        }

        public static String string(String[] array) {
            StringBuilder sb = new StringBuilder();
            openingBracket(sb);
            for (String in : array)
                sb.append(in).append(", ");
            if (array.length != 0)
                deleteLastComma(sb);
            closingBracket(sb);
            return sb.toString();
        }

        public static String string(int[][] array) {
            StringBuilder sb = new StringBuilder();
            openingBracketWithNewLine(sb);
            for (int[] in : array)
                sb.append("  ").append(string(in));
            closingBracket(sb);
            return sb.toString();
        }

        public static String string(long[][] array) {
            StringBuilder sb = new StringBuilder();
            openingBracketWithNewLine(sb);
            for (long[] in : array)
                sb.append("  ").append(string(in));
            closingBracket(sb);
            return sb.toString();
        }

        public static String string(double[][] array) {
            StringBuilder sb = new StringBuilder();
            openingBracketWithNewLine(sb);
            for (double[] in : array)
                sb.append("  ").append(string(in));
            closingBracket(sb);
            return sb.toString();
        }

        public static <T> String string(boolean[][] array) {
            StringBuilder sb = new StringBuilder();
            openingBracketWithNewLine(sb);
            for (boolean[] in : array)
                sb.append("  ").append(string(in));
            closingBracket(sb);
            return sb.toString();
        }

        public static String string(char[][] array) {
            StringBuilder sb = new StringBuilder();
            openingBracketWithNewLine(sb);
            for (char[] in : array)
                sb.append("  ").append(string(in));
            closingBracket(sb);
            return sb.toString();
        }

        public static String string(String[][] array) {
            StringBuilder sb = new StringBuilder();
            openingBracketWithNewLine(sb);
            for (String[] in : array)
                sb.append("  ").append(string(in));
            closingBracket(sb);
            return sb.toString();
        }

        public static <T> String stringi(List<T> list) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++)
                sb.append(i).append(": ").append(list.get(i)).append("\n");
            return sb.toString();
        }

        public static <T> String string(Collection<T> collection) {
            StringBuilder sb = new StringBuilder();
            openingBracket(sb);
            for (T t : collection)
                sb.append(t).append(", ");
            if (!collection.isEmpty())
                deleteLastComma(sb);
            closingBracket(sb);
            return sb.toString();
        }

        public static <T> String string2D(Collection<Collection<T>> collection) {
            StringBuilder sb = new StringBuilder();
            openingBracketWithNewLine(sb);
            for (Collection<T> t : collection)
                sb.append("  ").append(string(t));
            closingBracket(sb);
            return sb.toString();
        }

        public static <T> String string2Di(List<Collection<T>> list) {
            StringBuilder sb = new StringBuilder();
            openingBracketWithNewLine(sb);
            for (int i = 0; i < list.size(); i++)
                sb.append("  ").append(i).append(": ").append(string(list.get(i)));
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
            for (int i = 0; i < spec.length; i++)
                arr[i] = Integer.parseInt(spec[i]);
            return arr;
        }

        public static long inputLong(BufferedReader br) throws IOException {
            return Long.parseLong(br.readLine());
        }

        public static long[] inputLongArray(BufferedReader br) throws IOException {
            String[] spec = br.readLine().split(" ");
            long[] arr = new long[spec.length];
            for (int i = 0; i < spec.length; i++)
                arr[i] = Long.parseLong(spec[i]);
            return arr;
        }

        public static String inputString(BufferedReader br) throws IOException {
            return br.readLine();
        }

        public static String[] inputStringArray(BufferedReader br) throws IOException {
            return br.readLine().split(" ");
        }

        private static InputStreamReader inputStream() throws IOException {
            return ("why in the world not?".equals(System.getenv("LOCAL_CODING"))) ? fileInputStream()
                    : stdInputStream();
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
        }

        public static void debug(long val) {
            debug(String.valueOf(val));
        }

        public static void debug(boolean val) {
            debug(val ? "T" : "F");
        }

        public static void debug(String text) {
            debug(text, true);
        }

        public static void debug(String text, boolean append) {
            if (!"why in the world not?".equals(System.getenv("LOCAL_CODING")))
                return;
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
