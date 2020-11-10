package com.games.UVa.P11727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cases = Integer.parseInt(br.readLine());
    for (int i = 1; i <= cases; i++) {
      int[] nums = nums(br.readLine().split(" "));
      int min = 10001;
      int max = 999;
      for (int num : nums) {
        if (num < min)
          min = num;
        if (num > max)
          max = num;
      }
      int res = 0;
      for (int num : nums) {
        if (num != min && num != max)
          res = num;
      }
      System.out.printf("Case %d: %d\n", i, res);
    }
  }

  private static int[] nums(String[] texts) {
    int[] nums = new int[texts.length];
    for (int i = 0; i < texts.length; i++)
      nums[i] = Integer.parseInt(texts[i]);
    return nums;
  }
}
