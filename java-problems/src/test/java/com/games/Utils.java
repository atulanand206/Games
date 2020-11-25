package com.games;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Utils {
  public static void assertSameArray(int[] a1, int[] a2) {
    assertEquals(a2.length, a1.length);
    for (int i = 0; i < a1.length; i++)
      assertEquals(a1[i], a2[i]);
  }
}
