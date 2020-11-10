package com.games.UVa.P11498;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = "";
    while (!(line = br.readLine()).equals("0")) {
      int k = Integer.parseInt(line);
      int[] divs = nums(br.readLine().split(" "));
      while (k-- > 0) {
        int[] coords = nums(br.readLine().split(" "));
        if (divs[0] == (coords[0]) || divs[1] == (coords[1]))
          System.out.println("divisa");
        else if (coords[0] < divs[0]) {
          if (coords[1] < divs[1])
            System.out.println("SO");
          else
            System.out.println("NO");
        } else {
          if (coords[1] < divs[1])
            System.out.println("SE");
          else
            System.out.println("NE");
        }
      }
    }
  }

  private static int[] nums(String[] texts) {
    int[] nums = new int[texts.length];
    for (int i = 0; i < nums.length; i++) {
      nums[i] = Integer.parseInt(texts[i]);
    }
    return nums;
  }
}
