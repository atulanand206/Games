package com.games.SHCP3;

import java.util.Arrays;
import java.util.stream.Collectors;

public class P221 {

  public static boolean P2211(int[] array) {
    return Arrays.stream(array).boxed()
        .collect(Collectors.toMap(i -> i, i -> 1, Integer::sum))
        .values().stream().anyMatch(i -> i > 1);
  }

  public static int[] P2212(int[] array, int sum) {
    int[] ints = new int[2];

    return ints;
  }
  public static void main(String[] args) {

  }
}
