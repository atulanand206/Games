package com.games.UVa.P11547;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cases = Integer.parseInt(br.readLine());
    while (cases-- > 0) {
      System.out.println(Math.abs(((((((Integer.parseInt(br.readLine())) * 567) / 9 + 7492) * 235) / 47 - 498) % 100) / 10));
    }
  }
}
