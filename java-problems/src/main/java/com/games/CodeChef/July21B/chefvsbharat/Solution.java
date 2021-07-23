package com.games.CodeChef.July21B.chefvsbharat;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(I.inputStream());
        O.attach();
        long[] chefNums = getChefora();
        long[] calct = calc();
        O.debug(chefNums.length + " " + calct.length + "\n");

        O.debug(S.string(calct));
        O.debug(chefNums[115] + "\n");
        chefNums = calct;

        O.debug(S.string(chefNums));

        long[] sum = new long[chefNums.length];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++)
            sum[i] = sum[i - 1] + chefNums[i - 1];

        int t = I.inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int[] spec = I.inputIntArray(br);
            int l = spec[0], r = spec[1];
            long al = chefNums[l - 1];
            O.debug(al);
            long pr = sum[r];
            long pl = sum[l];
            long ais = pr - pl;
            O.debug(ais);
            sb.append(exponent(al, ais)).append("\n");
        }
        O.print(sb);
    }

    private static long[] calc() {
        long[] chefora = new long[(int) 1E5 + 5];
        for (int i = 0; i < chefora.length; i++) {
            int x = i + 1;
            StringBuilder k = new StringBuilder();
            k.append(x);
            if (k.length() == 1) {
                chefora[i] = x;
                continue;
            }
            String z = new StringBuilder(k).reverse().substring(1);
            k.append(z);
            chefora[i] = Long.parseLong(k.toString());
        } 
        return chefora;
    }

    private static int MOD = (int) (1E9 + 7);

    private static long exponent(long x, long y) {
        long res = 1; // Initialize result

        while (y > 0) {

            // If y is odd, multiply x with result
            if ((y & 1) != 0)
                res = (res * x) % MOD;

            // y must be even now
            y = y >> 1; // y = y/2
            x = (x * x) % MOD; // Change x to x^2
        }
        return res;
    }

    private static long[] getChefora() {
        char[][] chefora = new char[(int) 1E5 + 5][];
        chefora[0] = new char[] { '1' };
        int ix = 0;
        for (int i = 1; i < chefora.length; i++) {
            char[] p = chefora[i - 1];
            char[] n = p.clone();
            if (p[ix] < '9') {
                n[ix]++;
                chefora[i] = n;
                continue;
            }
            if (ix == 0) {
                n = new char[p.length + 2];
                n[0] = '1';
                for (int z = 1; z < n.length - 1; z++) {
                    n[z] = '0';
                }
                n[n.length - 1] = '1';
                ix = n.length / 2;
                chefora[i] = n;
                continue;
            }
            while (ix > 0 && n[ix - 1] == '9') {
                ix--;
            }
            if (ix > 0 && n[ix - 1] < '9') {
                n[ix - 1]++;
                n[p.length - ix]++;
                for (int z = ix; z < p.length - ix; z++) {
                    n[z] = '0';
                }
                ix = n.length / 2;
            }
            chefora[i] = n;
        }
        Set<String> set = new TreeSet<>();
        long[] chefNums = new long[chefora.length];
        for (int i = 0; i < chefora.length; i++) {
            String s = new String(chefora[i]);
            if (!set.contains(s) && s != "0") {
                chefNums[i] = Long.parseLong(s);
                set.add(s);
            }
        }
        return chefNums;
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
