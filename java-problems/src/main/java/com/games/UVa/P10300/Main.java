package com.games.UVa.P10300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cases = readInt(br);
    while (cases-- > 0) {
      int farmers = readInt(br);
      int premiumBudget = 0;
      while (farmers-- > 0) {
        String[] farmerSpecs = br.readLine().trim().split(" ");
        int farmSize = atIndex(farmerSpecs, 0);
        int friendliness = atIndex(farmerSpecs, 2);
        int friendlinessPerFarm = farmSize * friendliness;
        premiumBudget += friendlinessPerFarm;
      }
      System.out.println(premiumBudget);
    }
  }

  private static int atIndex(String[] farmerSpecs, int i) {
    return Integer.parseInt(farmerSpecs[i]);
  }

  private static int readInt(BufferedReader br) throws IOException {
    return Integer.parseInt(br.readLine().trim());
  }
}
