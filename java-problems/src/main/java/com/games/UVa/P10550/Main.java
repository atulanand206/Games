package com.games.UVa.P10550;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line = "";
    while (!(line = reader.readLine()).equals("0 0 0 0")) {
      String[] split = line.split(" ");
      int initial = Integer.parseInt(split[0]);
      int first = Integer.parseInt(split[1]);
      int second = Integer.parseInt(split[2]);
      int third = Integer.parseInt(split[3]);
      int counts = 40 * 3;
      int move1 = dist(first, initial);
      int move2 = dist(first, second);
      int move3 = dist(third, second);
      int total = counts + move1 + move2 + move3;
      System.out.println(total * 360 / 40);
    }
  }

  static int dist(int a, int b) {
    int sum = 0;
    int i = a;
    while (i != b) {
      i = (i + 1) % 40;
      sum++;
    }
    return sum;
  }
}
