package com.games.UVa.P11679;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = "";
    while (!(line = br.readLine().trim()).equals("0 0")) {
      String[] specs = line.split(" ");
      int banks = atIndex(specs, 0);
      int debentures = atIndex(specs, 1);
      int[] reserves = nums(br.readLine().trim());
      int banksLiquidated = 0;
      for (int i = 0; i < debentures; i++) {
        int[] bankSpecs = nums(br.readLine().trim());
        reserves[bankSpecs[0] - 1] -= bankSpecs[2];
        reserves[bankSpecs[1] - 1] += bankSpecs[2];
      }
      for (int i = 0; i < banks; i++)
        if (reserves[i] >= 0)
          banksLiquidated++;
      if (banksLiquidated == banks)
        System.out.println("S");
      else
        System.out.println("N");
    }
  }

  private static int[] nums(String text) {
    String[] array = text.split(" ");
    int[] a = new int[array.length];
    for (int i = 0; i < array.length; i++) {
      a[i] = Integer.parseInt(array[i]);
    }
    return a;
  }

  private static int atIndex(String[] array, int index) {
    return Integer.parseInt(array[index]);
  }
}
