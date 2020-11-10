package com.games.HR.salesByMatch;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public static int sockMerchant(int n, int[] ar) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int a : ar)
      map.merge(a, 1, Integer::sum);
    int pairs = 0;
    for (Map.Entry<Integer, Integer> entry : map.entrySet())
      pairs += entry.getValue() / 2;
    return pairs;
  }
}
