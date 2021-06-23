package com.games.CodeForces.beautifulString;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(I.inputStream());
        O.attach();
        int t = I.inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            char[] s = I.inputString(br).toCharArray();
            if (s.length == 1) {
                if (s[0] == '?') {
                    sb.append("a\n");
                } else {
                    sb.append(s).append("\n");
                }
                continue;
            }
            boolean fail = false;
            for (int i = 1; i < s.length; i++) {
                if (s[i] != '?' && s[i] == s[i - 1]) {
                    sb.append("-1\n");
                    fail = true;
                    break;
                }
            }
            if (fail)
                continue;
            if (s[0] == '?') {
                if (s[1] != '?') {
                    if (s[1] == 'a')
                        s[0] = 'b';
                    if (s[1] == 'b')
                        s[0] = 'c';
                    if (s[1] == 'c')
                        s[0] = 'a';
                } else {
                    s[0] = 'a';
                }
            }
            for (int i = 1; i < s.length - 1; i++) {
                if (s[i] != '?') continue;
                char prev = s[i - 1];
                char next = s[i + 1];
                if (next == '?') {
                    if (prev == 'a')
                        s[i] = 'b';
                    if (prev == 'b')
                        s[i] = 'c';
                    if (prev == 'c')
                        s[i] = 'a';
                } else {
                    Set<Character> set = new HashSet<>();
                    set.add('a');
                    set.add('b');
                    set.add('c');
                    set.remove(prev);
                    set.remove(next);
                    s[i] = set.iterator().next();
                }
            }
            int x = s.length - 1;
            if (s[x] == '?') {
                if (s[x - 1] != '?') {
                    if (s[x - 1] == 'a')
                        s[x] = 'b';
                    if (s[x - 1] == 'b')
                        s[x] = 'c';
                    if (s[x - 1] == 'c')
                        s[x] = 'a';
                } else {
                    s[x] = 'a';
                }
            }
            sb.append(new String(s) + "\n");
        }
        O.print(sb);
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
