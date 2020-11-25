package com.games.SHCP3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

  public static int[] P2214(int[] array, int start, int end) {
    List<Integer> ints = new ArrayList<>();
    for (int i : array) {
      if (i >= start && i <= end)
        ints.add(i);
    }
    ints.sort(Integer::compareTo);
    return ints.stream().mapToInt(Integer::intValue).toArray();
  }

  public static int P2215(int[] array) {
    int maxLength = 1, currentLength = 1;
    for (int j = 0; j < array.length - 1; j++) {
      if (array[j + 1] >= array[j]) {
        currentLength++;
        maxLength = Math.max(maxLength, currentLength);
      } else {
        currentLength = 1;
      }
    }
    return maxLength;
  }

  public static int P2216(int[] array) {
    List<Integer> integers = Arrays.stream(array).boxed()
        .sorted(Integer::compareTo)
        .collect(Collectors.toList());
    return integers.get(integers.size() / 2);
  }

  public static void main(String[] args) {

  }
}
