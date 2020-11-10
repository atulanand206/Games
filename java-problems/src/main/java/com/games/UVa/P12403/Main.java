package com.games.UVa.P12403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int steps = Integer.parseInt(br.readLine());
    int balance = 0;
    while (steps-- > 0) {
      String step = br.readLine();
      if (step.charAt(0)=='d')
        balance += Integer.parseInt(step.split(" ")[1]);
      else if (step.charAt(0)=='r')
        System.out.println(balance);
    }
  }
}
