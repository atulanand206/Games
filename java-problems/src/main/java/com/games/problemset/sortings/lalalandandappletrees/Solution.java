package com.games.problemset.sortings.lalalandandappletrees;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
    
public class Solution {

    private static class Item {
        int position;
        int apples;
        int rank;
        static Item of(int position, int apples) {
            Item item = new Item();
            item.position = position;
            item.apples = apples;
            return item;
        }

        public String toString() {
            return String.format("(Position: %d, Apples: %d)", position, apples);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(I.inputStream());
        O.attach();
        int t = I.inputInt(br);
        List<Item> items = new ArrayList<>();
        while (t-- > 0) {
            int[] spec = I.inputIntArray(br);
            items.add(Item.of(spec[0], spec[1]));
        }
        items.sort((a, b) -> Integer.compare(a.position, b.position));
        int maxNeg = Integer.MIN_VALUE;
        int minPos = Integer.MAX_VALUE;
        for (Item item : items) {
            if (item.position < 0 && item.position > maxNeg)
                maxNeg = item.position;
            if (item.position > 0 && item.position < minPos)
                minPos = item.position;
        }
        int maxNegIx = maxNeg;
        int minPosIx = minPos;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).position == maxNeg)
                maxNegIx = i;
            if (items.get(i).position == minPos) 
                minPosIx = i;
        }
        if (minPosIx == Integer.MAX_VALUE 
            && maxNegIx == Integer.MIN_VALUE) {
            O.print(0);
            return;
        }
        if (minPosIx == Integer.MAX_VALUE) {
            O.print(items.get(maxNegIx).apples);
            return;
        }
        if (maxNegIx == Integer.MIN_VALUE) {
            O.print(items.get(minPosIx).apples);
            return;
        }
        int f = oneside(items, maxNegIx, minPosIx);
        int g = otherside(items, maxNegIx, minPosIx);
        O.print(Math.max(f, g));
    }

    private static int oneside(List<Item> items, int maxNegIx, int minPosIx) {
        int p = maxNegIx;
        int q = minPosIx;
        int aaps = 0;
        while (true) {
            if (q < items.size()) {
                aaps += items.get(q).apples;
                q++;
            } else {
                break;
            }
            if (p >= 0) {
                aaps += items.get(p).apples;
                p--;
            } else {
                break;
            }
        }
        return aaps;
    }

    private static int otherside(List<Item> items, int maxNegIx, int minPosIx) {
        int p = maxNegIx;
        int q = minPosIx;
        int aaps = 0;
        while (true) {
            if (p >= 0) {
                aaps += items.get(p).apples;
                p--;
            } else {
                break;
            }
            if (q < items.size()) {
                aaps += items.get(q).apples;
                q++;
            } else {
                break;
            }
        }
        return aaps;
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

        public static String[] inputStringArray(BufferedReader br) throws IOException {
            return br.readLine().split(" ");
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
}
