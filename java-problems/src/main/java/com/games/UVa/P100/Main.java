package com.games.UVa.P100;

import java.io.IOException;
import java.util.StringTokenizer;

class Main {
  static int cycles(int num) {
    int cycles = 1;
    while (num != 1) {
      if (num % 2 == 0)
        num = num / 2;
      else
        num = 3 * num + 1;
      cycles++;
    }
    return cycles;
  }

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
    StringTokenizer idata;
    int a, b, min, max, num, n, cycle;
    int cyclemax;

    String input;
    while ((input = ReadLn(255)) != null) {
      idata = new StringTokenizer(input);
      a = Integer.parseInt(idata.nextToken());
      b = Integer.parseInt(idata.nextToken());
      if (a < b) {
        min = a;
        max = b;
      } else {
        min = b;
        max = a;
      }
      cyclemax = -1;
      for (int i = min; i <= max; i++) {
        cyclemax = Math.max(cyclemax, cycles(i));
      }
      System.out.println(a + " " + b + " " + cyclemax);
    }
  }
}
