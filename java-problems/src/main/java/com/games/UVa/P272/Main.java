package com.games.UVa.P272;

import java.io.IOException;

public class Main {

  String toReplace = "``";

  static String ReadLn(int maxLg) {
    byte[] lin = new byte[maxLg];
    int lg = 0, car = -1;
    String line = "";

    try {
      while (lg < maxLg) {
        car = System.in.read();
        if ((car < 0) || (car == '\n')) break;
        lin[lg++] += car;
      }
    } catch (IOException e) {
      return (null);
    }

    if ((car < 0) && (lg == 0)) return (null);  // eof
    return (new String(lin, 0, lg));
  }

  public static void main(String[] args) {
    Main main = new Main();
    String input;
    while ((input = ReadLn(255)) != null) {
      StringBuilder output = new StringBuilder();
      for (char ch : input.toCharArray()) {
        if (ch == '"') {
          output.append(main.toReplace);
          main.toggleReplace();
        } else
          output.append(ch);
      }
      System.out.println(output.toString());
    }
  }

  private void toggleReplace() {
    if (toReplace.equals("``"))
      toReplace = "''";
    else
      toReplace = "``";
  }
}
