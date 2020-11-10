package com.games.UVa.P573;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = "";
    while (!(line = br.readLine()).startsWith("0")) {
      String[] specs = line.trim().split(" ");
      int wellHeight = at(specs, 0);
      int firstClimb = at(specs, 1);
      int dailyDrop = at(specs, 2);
      int fatiguePercent = at(specs, 3);
      double fatigue = (double) fatiguePercent * firstClimb / 100;
      double currentPosition = 0;
      double todaysClimb = firstClimb;
      int day = 1;
      while (true) {
        currentPosition += todaysClimb;
        if (currentPosition > wellHeight) {
          System.out.printf("success on day %s\n", day);
          break;
        }
        currentPosition -= dailyDrop;
        if (currentPosition < 0) {
          System.out.printf("failure on day %s\n", day);
          break;
        }
        todaysClimb = Math.max(todaysClimb - fatigue, 0);
        day++;
      }
    }
  }

  private static int at(String[] array, int index) {
    return Integer.parseInt(array[index]);
  }
}
