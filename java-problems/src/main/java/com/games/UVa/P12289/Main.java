package com.games.UVa.P12289;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cases = Integer.parseInt(br.readLine());
    for (int i = 0; i < cases; i++) {
      String text = br.readLine();
      if (text.length() == 5)
        System.out.println(3);
      else if (text.length() == 3) {
        if ((text.charAt(0) == 'o' && text.charAt(1) == 'n') || (text.charAt(0) == 'o' && text.charAt(2) == 'e') || (text.charAt(1) == 'n' && text.charAt(2) == 'e'))
          System.out.println(1);
        else
          System.out.println(2);
      }
    }
  }
}
