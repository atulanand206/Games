package com.games.UVa.P11364;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cases = Integer.parseInt(br.readLine());
    while (cases-- > 0) {
      int elementsSize = Integer.parseInt(br.readLine());
      String[] elementsString = br.readLine().split(" ");
      int l = 100;
      int r = -1;
      for (String element : elementsString) {
        int num = Integer.parseInt(element);
        if (num < l)
          l = num;
        if (num > r)
          r = num;
      }
      System.out.println(2 * (r - l));
    }
  }
}
