package com.games.CF.codl;

// you can also use imports, for example:
import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(I.inputStream());
    O.attach();
    StringBuilder sb = new StringBuilder();
    int[] arr = new int[20];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (int) (i * 5 * 1E7);
    }
    // arr = I.inputIntArray(br);
    sb.append(solution(arr));
    O.print(sb);
  }

  private static int MOD = (int) (1E9 + 7);

  public static int solution(int[] A) {
    // write your code in Java SE 8
    long min = Long.MAX_VALUE;
    long[] prf = prefix(A);
    long[] pr = prefixS(prf);
    O.debug(S.string(A));
    O.debug(S.string(prf));
    O.debug(S.string((pr)));
    for (int i = 0; i < A.length; i++) {
      long x = 0;
      if (i < A.length - 1) x += pr[i+1];
      x = (x + pr[0]) % MOD;
      x = (x - pr[i]) % MOD;
      x = (x - (i * prf[i]) % MOD) % MOD;
      min = Math.min(min, x);
    }
    return (int)min;
  }

  public static long[] prefix(int[] arr) {
    long[] x = new long[arr.length];
    for (int i = arr.length - 2; i >= 0; i--) {
      x[i] = x[i + 1] + arr[i + 1] - arr[i];
    }
    return x;
  }

  public static long[] prefixS(long[] arr) {
    long[] x = new long[arr.length];
    for (int i = arr.length - 2; i >= 0; i--) {
      x[i] = x[i + 1] + arr[i];
    }
    return x;
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
      return ("why in the world not?".equals(System.getenv("LOCAL_CODING"))) ? fileInputStream() : stdInputStream();
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