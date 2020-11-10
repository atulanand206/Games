package com.games.UVa.P11799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cases = Integer.parseInt(br.readLine().trim());
    for (int i = 1; i <= cases; i++) {
      String[] splits = br.readLine().split(" ");
      int minSpeed = 1;
      if (Integer.parseInt(splits[0]) >= 1)
        for (int j = 1; j < splits.length; j++) {
          int speed = Integer.parseInt(splits[j]);
          if (speed > minSpeed)
            minSpeed = speed;
        }
      System.out.printf("Cases %d: %d\n", i, minSpeed);
    }
  }
}
