package com.games.UVa.P11956;

import org.junit.jupiter.api.Test;

import static com.games.UVa.P11956.Main.getState;
import static com.games.UVa.P11956.Main.printState;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

  @Test
  void testBrainFuck() {
    String actual = printState(getState("..++<><<+++>>++++++++++++++++++++++++++>" +
        ">>+++<+...++<><<+++>>++++++++++++++++++++++++++>>>+++<" +
        "+...++<><<+++>>++++++++++++++++++++++++++>>>+++<+.", 100), 1).toString();
    String expected = "Case 1: 1F 00 20 03 1D 03 01 03 00 00 00 00 " +
        "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 " +
        "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 " +
        "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 " +
        "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 " +
        "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 " +
        "00 00 00 00 00 00 00 00 00 00 00 03 00";
    assertEquals(expected, actual);
  }

  @Test
  void testGetState() {
    assertSame(new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, getState("+", 10));
    assertSame(new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0}, getState("++", 10));
    assertSame(new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0}, getState("++>", 10));
    assertSame(new int[]{2, 1, 0, 0, 0, 0, 0, 0, 0, 0}, getState("++>+", 10));
    assertSame(new int[]{2, 1, 0, 0, 0, 0, 0, 0, 0, 1}, getState("++>+<<+", 10));
    assertSame(new int[]{2, 1, 0, 0, 0, 0, 0, 0, 255, 1}, getState("++>+<<+<-", 10));
    assertSame(new int[]{2, 1, 0, 0, 0, 0, 0, 0, 255, 1}, getState("++...>+<<+<-", 10));
    assertSame(new int[]{2, 1, 0, 0, 0, 0, 0, 0, 253, 1}, getState("++...>+<<+<---", 10));
    assertSame(new int[]{2, 1, 0, 0, 0, 0, 0, 0, 0, 1}, getState("++...>+<<+<---+++", 10));
    assertSame(new int[]{3, 1, 255, 0, 0, 0, 0, 0, 0, 1}, getState("++...>+<<+<---+++>>+>>-", 10));
    assertSame(new int[]{3, 1, 0, 0, 0, 0, 0, 0, 0, 1}, getState("++...>+<<+<---+++>>+>>-+", 10));
    assertSame(new int[]{3, 1, 1, 0, 0, 0, 0, 0, 0, 1}, getState("++...>+<<+<---+++>>+>>-++", 10));
    assertSame(new int[]{2, 1, 1, 0, 0, 0, 0, 0, 0, 1}, getState("++...>+<<+<---+++>>+>>-++<<-", 10));
    assertSame(new int[]{2, 1, 1, 0, 0, 0, 0, 0, 0, 255}, getState("++...>+<<+<-...--+++>>+>>-+....+<<-<--", 10));
  }

  void assertSame(int[] a1, int[] a2) {
    assertEquals(a2.length, a1.length);
    for (int i = 0; i < a1.length; i++)
      assertEquals(a1[i], a2[i]);
  }

  @Test
  void testWrapping() {
    System.out.println((255 + 1) % 256);
  }

}