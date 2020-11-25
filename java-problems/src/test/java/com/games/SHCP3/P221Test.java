package com.games.SHCP3;

import org.junit.jupiter.api.Test;

import static com.games.SHCP3.P221.P2211;
import static com.games.SHCP3.P221.P2212;
import static com.games.SHCP3.P221.P2214;
import static com.games.SHCP3.P221.P2215;
import static com.games.SHCP3.P221.P2216;
import static com.games.Utils.assertSameArray;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

  @Test
  void testP2214() {
    assertSameArray(new int[]{3, 4}, P2214(new int[]{6, 8, 1, 2, 3, 4}, 3, 5));
    assertSameArray(new int[]{2, 3, 4}, P2214(new int[]{6, 8, 3, 4, 1, 2}, 2, 5));
    assertSameArray(new int[]{2, 3, 4, 6}, P2214(new int[]{6, 8, 3, 4, 1, 2}, 2, 6));
  }

  @Test
  void testP2215() {
    assertEquals(5, P2215(new int[]{4, 3, 5, 2, 4, 5, 6, 7, 1, 2, 4}));
    assertEquals(4, P2215(new int[]{4, 3, 5, 2, 1, 5, 6, 7, 1, 2, 4}));
    assertEquals(5, P2215(new int[]{4, 3, 5, 2, 2, 5, 6, 7, 1, 2, 4}));
  }

  @Test
  void testP2216() {
    assertEquals(4, P2216(new int[]{4, 3, 5, 2, 4, 5, 6, 7, 1, 2, 4}));
    assertEquals(4, P2216(new int[]{4, 3, 5, 2, 1, 5, 6, 7, 1, 2, 4}));
    assertEquals(4, P2216(new int[]{4, 3, 5, 2, 2, 5, 6, 7, 1, 2, 4}));
  }

}