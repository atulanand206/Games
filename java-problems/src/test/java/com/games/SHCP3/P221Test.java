package com.games.SHCP3;

import org.junit.jupiter.api.Test;

import static com.games.SHCP3.P221.P2211;
import static com.games.SHCP3.P221.P2212;
import static org.junit.jupiter.api.Assertions.*;

class P221Test {

  @Test
  void testP2211() {
    assertTrue(P2211(new int[]{3, 2, 1, 2, 4}));
    assertTrue(P2211(new int[]{3, 2, 4, 2, 4}));
    assertFalse(P2211(new int[]{3, 2, 1, 5, 4}));
  }

  @Test
  void testP2212() {
    assertEquals(new int[]{3, 1}, P2212(new int[]{3, 2, 1, 2, 4}, 4));
    assertEquals(new int[]{2, 2}, P2212(new int[]{3, 2, 2, 2, 4}, 4));
    assertEquals(new int[]{3, 2}, P2212(new int[]{3, 2, 2, 2, 4}, 5));
  }

}