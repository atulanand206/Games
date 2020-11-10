package com.games.UVa.P11956;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cases = Integer.parseInt(br.readLine().trim());
    for (int i = 1; i <= cases; i++) {
      String input = br.readLine();
      int[] set = getState(input, 100);
      StringBuilder sb = printState(set, cases);
      System.out.println(sb.toString());
    }
  }

  public static StringBuilder printState(int[] set, int cases) {
    StringBuilder sb = new StringBuilder("Case ");
    sb.append(cases);
    sb.append(": ");
    for (int i = 0; i < set.length; i++) {
      int s = set[i];
      if (i != 0)
        sb.append(" ");
      sb.append(String.format("%02X", (s)));
    }
    return sb;
  }

  public static int[] getState(String input, int length) {
    int width = 256;
    int[] set = new int[length];
    int current = 0;
    for (char ch : input.toCharArray()) {
      if (ch == '>')
        current = (current + 1) % length;
      if (ch == '<')
        current = (current - 1 + length) % length;
      if (ch == '+')
        set[current] = (set[current] + 1) % width;
      if (ch == '-')
        set[current] = (set[current] - 1 + width) % width;
    }
    return set;
  }
}
