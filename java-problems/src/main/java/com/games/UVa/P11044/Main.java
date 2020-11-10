package com.games.UVa.P11044;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int read = Integer.parseInt(reader.readLine());
    while (read-- > 0) {
      String line = reader.readLine();
      String[] split = line.split(" ");
      int x = Integer.parseInt(split[0]);
      int y = Integer.parseInt(split[1]);
      System.out.println((x / 3) * (y / 3));
    }
  }
}
