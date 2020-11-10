package com.games.UVa.P12279;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int count = 1;
    while (Integer.parseInt(br.readLine()) != (0)) {
      int[] nums = nums(br.readLine());
      int balance = 0;
      for (int num : nums) {
        if (num == 0)
          balance--;
        else
          balance++;
      }
      System.out.printf("Case %d: %d\n", count++, balance);
    }
  }

  private static int[] nums(String text) {
    String[] splits = text.split(" ");
    int[] nums = new int[splits.length];
    for (int i = 0; i < splits.length; i++)
      nums[i] = Integer.parseInt(splits[i]);
    return nums;
  }
}
