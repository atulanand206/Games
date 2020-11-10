package com.games.UVa.P11687;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = "";
    while (!(line = br.readLine()).equals("END")) {
      String xi = line;
      int i=0;
      while (!xi.equals(countDigits(xi))) {
        xi = countDigits(xi);
        i++;
      }
      System.out.println(i+1);
    }
  }

  private static String countDigits(String x) {
    return String.valueOf(x.length());
  }
}
