package com.games.gaoc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import com.games.CodeForces.alexandbrokencontest.Solution.O;

public class DumboOctopus {

  private static final int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { -1, -1 },
      { -1, 1 }, { 1, -1 }, { 1, 1 } };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(I.fileInputStream());
    O.attach();
    int[][] lines = new int[10][];
    int k = 0;
    while (br.ready())
      lines[k++] = I.inputIntArray(br);
    O.debug(S.string(lines));
    int z = 0;
    for (int t = 1; t <= 200; t++) {
      for (int i = 0; i < lines.length; i++)
        for (int j = 0; j < lines[i].length; j++)
          lines[i][j] = (lines[i][j] + 1) % 10;
      int[][] da = new int[10][10];
      int q = 100;
      while (q != 0) {
        q = 0;
        for (int i = 0; i < lines.length; i++)
          for (int j = 0; j < lines[i].length; j++)
            if (lines[i][j] != 0) {
              int xx = 0;
              for (int[] direction : directions)
                if (isValid(i, j, direction)) {
                  int val = value(lines, i, j, direction);
                  int ni = i + direction[0];
                  int nj = j + direction[1];
                  xx++;
                }
              if (lines[i][j] + xx >= 10)
                q++;
              da[i][j] = lines[i][j] + xx >= 10 ? 0 : (lines[i][j] + xx) % 10;
            }
      }
      lines = da;
      for (int i = 0; i < lines.length; i++)
        for (int j = 0; j < lines[i].length; j++)
          if (lines[i][j] == 0)
            z++;
      O.debug(S.string(lines));
    }
    O.print(z);
  }

  private static boolean isValid(int i, int j, int[] direction) {
    int ni = i + direction[0];
    int nj = j + direction[1];
    return (ni >= 0 && ni < 10 && nj >= 0 && nj < 10);
  }

  private static int value(int[][] lines, int i, int j, int[] direction) {
    int ni = i + direction[0];
    int nj = j + direction[1];
    return lines[ni][nj];
  }

  public static class I {

    public static int[] inputIntArray(BufferedReader br) throws IOException {
      String[] spec = br.readLine().split("");
      int[] arr = new int[spec.length];
      for (int i = 0; i < spec.length; i++)
        arr[i] = Integer.parseInt(spec[i]);
      return arr;
    }

    private static InputStreamReader fileInputStream() throws FileNotFoundException {
      return new InputStreamReader(new FileInputStream("input.txt"), StandardCharsets.UTF_8);
    }
  }

  public static class S {

    public static <T> String string(T val) {
      return val + "\n";
    }

    public static String string(int[] array) {
      StringBuilder sb = new StringBuilder();
      for (int in : array)
        sb.append(in).append("");
      // if (array.length != 0)
      // deleteLastComma(sb);
      sb.append("\n");
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
      for (int[] in : array)
        sb.append("").append(string(in));
      sb.append("\n");
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

}
