package com.games.CodeForces.distance;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(I.inputStream());
    O.attach();
    int n = I.inputInt(br);
    StringBuilder sb = new StringBuilder();
    while (n-- > 0) {
      int[] q = I.inputIntArray(br);
      int x = -1;
      int y = -1;
      int manhatten = q[0] + q[1];
      if (manhatten % 2 != 0) {
        sb.append(x).append(" ").append(y).append("\n");
        continue;
      }
      int distance = manhatten / 2;
      if (q[0] > q[1]) {
        x = q[0] - distance;
        y = q[1];
      } else {
        x = q[0];
        y = q[1] - distance;
      }
      sb.append(x).append(" ").append(y).append("\n");
    }
    O.print(sb);
  }

  /*
   * (0, 0), (x, y), (a, b)
   * x + y = |a - x| + |b - y|
   */

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
      return ("why in the world not?".equals(System.getenv("LOCAL_CODING")))
          ? fileInputStream()
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