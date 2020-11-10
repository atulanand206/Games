package com.games.UVa.P621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cases = Integer.parseInt(br.readLine());
    while (cases-- > 0) {
      String text = br.readLine();
      if (text.matches("[0-9]*[35]")) {
        System.out.println("-");
      } else if (text.matches("[9][0-9][4]")) {
        System.out.println("*");
      } else if (text.matches("[190][0-9]*")) {
        System.out.println("?");
      } else {
        System.out.println("+");
      }
    }
  }
}
