package com.games.UVa.P467;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {

  @Test
  void testSyncTime() {
    assertEquals(50, Main.syncTime("25 25 25 25 25"));
    assertEquals(300, Main.syncTime("30 25 35"));
  }

  @Test
  void testAllGreens() {
    assertTrue(Main.allGreens(20, new ArrayList<>(Arrays.asList(25, 25, 25, 25, 25))));
  }
}