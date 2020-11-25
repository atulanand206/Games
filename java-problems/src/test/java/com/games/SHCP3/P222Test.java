package com.games.SHCP3;

import org.junit.jupiter.api.Test;

import static com.games.SHCP3.P222.P2221;
import static com.games.SHCP3.P222.P2222;
import static com.games.SHCP3.P222.areAllZeroes;
import static com.games.SHCP3.P222.atLeastOneZero;
import static com.games.SHCP3.P222.bitSubset;
import static com.games.SHCP3.P222.isOneZero;
import static com.games.SHCP3.P222.nextEven;
import static com.games.SHCP3.P222.swap;
import static com.games.Utils.assertSameArray;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class P222Test {

  @Test
  void testP2221() {
    assertEquals(3, P2221(7, 4));
  }

  @Test
  void testP2222() {
    assertTrue(P2222(2));
    assertTrue(P2222(4));
    assertTrue(P2222(1));
    assertTrue(P2222(8));
    assertFalse(P2222(0));
    assertFalse(P2222(3));
  }

  @Test
  void testBits() {
    assertTrue(isOneZero(1, 0));
    assertFalse(isOneZero(0, 0));
    assertFalse(isOneZero(10, 10));
    assertTrue(areAllZeroes(0, 0, 0));
    assertFalse(areAllZeroes(0, 0, 1));
    assertFalse(areAllZeroes(2, 0, 1));
    assertFalse(areAllZeroes(2, 3, 1));
    assertTrue(atLeastOneZero(1, 2, 0));
    assertFalse(atLeastOneZero(1, 2, 3));
  }

  @Test
  void testNext() {
    assertEquals(2, nextEven(1));
    assertEquals(6, nextEven(4));
    assertEquals(4, nextEven(3));
  }

  @Test
  void testSwap() {
    assertSameArray(new int[]{3, 2}, swap(2, 3));
  }

  @Test
  void testBitSubset() {
    System.out.println(Integer.toBinaryString(31));
    System.out.println(Integer.toBinaryString(30));
    assertTrue(bitSubset(30, 31));
  }
}
