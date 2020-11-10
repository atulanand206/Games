package com.games.UVa.P11559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = "";
    while ((line = br.readLine()) != null) {
      String[] specs = line.trim().split(" ");
      int participants = atIndex(specs, 0);
      int budget = atIndex(specs, 1);
      int hotels = atIndex(specs, 2);
      int minCost = budget + 1;
      while (hotels-- > 0) {
        int price = Integer.parseInt(br.readLine().trim());
        int[] beds = nums(br.readLine().trim().split(" "));
        for (int i = 0; i < beds.length; i++) {
          if (beds[i] < participants)
            continue;
          int cost = price * participants;
          if (cost < minCost) {
            minCost = cost;
          }
        }
      }
      if (minCost > budget)
        System.out.println("stay home");
      else
        System.out.println(minCost);
    }
  }

  private static int atIndex(String[] array, int index) {
    return Integer.parseInt(array[index]);
  }

  private static int[] nums(String[] array) {
    int[] nums = new int[array.length];
    for (int i = 0; i < array.length; i++) {
      nums[i] = Integer.parseInt(array[i]);
    }
    return nums;
  }
}
