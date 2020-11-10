package com.games.UVa.P11172;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cases = Integer.parseInt(br.readLine());
    while (cases-- > 0) {
      String[] nums = br.readLine().split(" ");
      int f = Integer.parseInt(nums[0]);
      int s = Integer.parseInt(nums[1]);
      if (f < s)
        System.out.println("<");
      if (f > s)
        System.out.println(">");
      if (f == s)
        System.out.println("=");
    }
  }
}
