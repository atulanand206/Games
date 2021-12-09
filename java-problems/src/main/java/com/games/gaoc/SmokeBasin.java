package com.games.gaoc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class SmokeBasin {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(I.fileInputStream());
    List<int[]> lines = new ArrayList<>();
    while (br.ready())
      lines.add(I.inputIntArray(br));
    boolean[][] marked = lowPoints(lines);
    long res = lowPointsSum(lines, marked);
    System.out.println(res);
    System.out.println(basinSizes(lines, marked));
  }

  private static boolean[][] lowPoints(List<int[]> lines) {
    boolean[][] marked = new boolean[lines.size()][lines.get(0).length];
    for (int i = 0; i < lines.size(); i++)
      for (int j = 0; j < lines.get(i).length; j++)
        if (lower(lines, i, j))
          marked[i][j] = true;
    return marked;
  }

  private static long lowPointsSum(List<int[]> vals, boolean[][] marked) {
    long res = 0;
    for (int i = 0; i < marked.length; i++)
      for (int j = 0; j < marked[i].length; j++)
        if (marked[i][j])
          res += 1 + vals.get(i)[j];
    return res;
  }

  private static int basinSizes(List<int[]> vals, boolean[][] marked) {
    List<Integer> sizes = new ArrayList<>();
    boolean[][] visited = new boolean[marked.length][marked[0].length];
    for (int i = 0; i < marked.length; i++)
      for (int j = 0; j < marked[i].length; j++)
        visited[i][j] = marked[i][j];

    for (int i = 0; i < marked.length; i++)
      for (int j = 0; j < marked[i].length; j++)
        if (visited[i][j])
          sizes.add(dfs(vals, i, j, marked));

    return sizes.stream()
        .sorted(Comparator.reverseOrder())
        .limit(3)
        .reduce(1, (a, b) -> a * b);
  }

  private static final int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

  private static int dfs(List<int[]> floor, int x, int y, boolean[][] visited) {
    Stack<Pair> stk = new Stack<>();
    stk.push(Pair.of(x, y));
    visited[x][y] = true;
    int cnt = 1;
    while (!stk.isEmpty()) {
      Pair pnt = stk.pop();
      for (int[] direction : directions) {
        int nx = pnt.f + direction[0];
        int ny = pnt.s + direction[1];
        if (nx >= 0 && nx < floor.size() && ny >= 0 && ny < floor.get(nx).length) {
          if (floor.get(nx)[ny] == 9) {
            continue;
          }
          if (!visited[nx][ny] && floor.get(nx)[ny] > floor.get(x)[y]) {
            stk.push(Pair.of(nx, ny));
            cnt++;
            visited[nx][ny] = true;
          }
        }
      }
    }
    return cnt;
  }

  private static boolean lower(List<int[]> lines, int x, int y) {
    if (x < lines.size() - 1)
      if (lines.get(x + 1)[y] <= lines.get(x)[y])
        return false;
    if (y < lines.get(x).length - 1)
      if (lines.get(x)[y + 1] <= lines.get(x)[y])
        return false;
    if (x > 0)
      if (lines.get(x - 1)[y] <= lines.get(x)[y])
        return false;
    if (y > 0)
      if (lines.get(x)[y - 1] <= lines.get(x)[y])
        return false;
    return true;
  }

  private static class Pair {
    int f, s;

    Pair(int x, int s) {
      this.f = x;
      this.s = s;
    }

    static Pair of(int f, int s) {
      return new Pair(f, s);
    }

    @Override
    public String toString() {
      return "Pair{" +
          "f=" + f +
          ", s=" + s +
          '}';
    }
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
}
