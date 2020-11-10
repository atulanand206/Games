package com.games.UVa.P10963;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cases = readLine(br);
    for (int j = 0; j < cases; j++) {
      br.readLine();
      int columns = readLine(br);
      Set<Integer> diffs = new HashSet<>();
      for (int i = 0; i < columns; i++) {
        String[] edges = br.readLine().split(" ");
        int yN = atIndex(edges, 0);
        int yS = atIndex(edges, 1);
        diffs.add(yN - yS);
      }
      if (j != 0)
        System.out.println();
      if (diffs.size() == 1) {
        System.out.println("yes");
      } else {
        System.out.println("no");
      }
    }
  }

  private static int atIndex(String[] array, int index) {
    return Integer.parseInt(array[index]);
  }

  private static int readLine(BufferedReader br) throws IOException {
    return Integer.parseInt(br.readLine().trim());
  }
}
