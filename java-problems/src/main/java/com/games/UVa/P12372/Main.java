package com.games.UVa.P12372;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cases = Integer.parseInt(br.readLine());
    for (int i = 1; i <= cases; i++) {
      String result = "bad";
      int[] nums = nums(br.readLine().split(" "));
      if (nums.length == 3) {
        if (nums[0] <= 20 && nums[1] <= 20 && nums[2] <= 20)
          result = "good";
      }
      System.out.printf("Case %d: %s\n", i, result);
    }
  }

  private static int[] nums(String[] texts) {
    int[] nums = new int[texts.length];
    for (int i = 0; i < texts.length; i++) {
      nums[i] = Integer.parseInt(texts[i]);
    }
    return nums;
  }
}
