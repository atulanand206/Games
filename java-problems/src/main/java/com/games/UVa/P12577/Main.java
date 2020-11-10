package com.games.UVa.P12577;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String print1 = "Akbar";
    String print2 = "Asghar";
    String line = "";
    int i = 1;
    while (!(line = br.readLine()).equals("*")) {
      String print;
      if (line.equals("Hajj"))
        print = print1;
      else
        print = print2;
      System.out.printf("Case %d: Hajj-e-%s\n", i++, print);
    }
  }
}
