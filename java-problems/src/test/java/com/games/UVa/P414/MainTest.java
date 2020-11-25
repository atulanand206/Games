package com.games.UVa.P414;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

  @Test
  void testTotalSpaces() {
    assertEquals(4, Main.getTotalSpaces(new ArrayList<>(Arrays.asList("XXXXBBBBBBBBBBBBBBBBXXXXX", "XXXBBBBBBBBBBBBBBBXXXXXXX", "XXXXXBBBBBBBBBBBBBBBBXXXX", "XXBBBBBBBBBBBBBBBBBXXXXXX"))));
  }
}