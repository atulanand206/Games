package com.games.UVa.P11332;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = "";
    while (!(line = br.readLine()).equals("0")) {
      int sum = sumOfDigits(line);
      while (sum / 10 != 0) {
        sum = sumOfDigits(sum);
      }
      System.out.println(sum);
    }
  }

  private static int sumOfDigits(String line) {
    int sum = 0;
    for (char ch : line.toCharArray()) {
      sum += Integer.parseInt(String.valueOf(ch));
    }
    return sum;
  }

  private static int sumOfDigits(int number) {
    int sum = 0, num = number;
    while (num != 0) {
      sum += num % 10;
      num = num / 10;
    }
    return sum;
  }
}
