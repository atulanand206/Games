package com.games.UVa.P11764;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cases = Integer.parseInt(br.readLine());
    for (int i = 1; i <= cases; i++) {
      int highJumps = 0, lowJumps = 0;
      int walls = Integer.parseInt(br.readLine().trim());
      int[] heights = nums(br.readLine().trim());
      if (walls > 1) {
        for (int j = 0; j < heights.length - 1; j++) {
          int currentHeight = heights[j];
          int nextHeight = heights[j + 1];
          if (nextHeight > currentHeight)
            highJumps++;
          else if (nextHeight < currentHeight)
            lowJumps++;
        }
      }
      System.out.printf("Case %d: %d %d\n", i, highJumps, lowJumps);
    }
  }

  private static int[] nums(String array) {
    String[] splits = array.split(" ");
    int[] nums = new int[splits.length];
    for (int i = 0; i < splits.length; i++)
      nums[i] = Integer.parseInt(splits[i]);
    return nums;
  }
}
