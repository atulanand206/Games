package com.games.CLRS;

import org.junit.jupiter.api.Test;

class E5_12Test {

  @Test
  void testRandom() {
    final var e512 = new E5_12();
    System.out.printf("%.0f\n", e512.random(10, 32));
    System.out.printf("%.0f\n", e512.random(43, 32));
    System.out.printf("%.0f\n", e512.random(12, 24));
    System.out.printf("%.0f\n", e512.random(15, 13));
    System.out.printf("%.0f\n", e512.random(50, 53));
    System.out.println(e512.biasedRandom(10, 32));
    System.out.println(e512.biasedRandom(10, 32));
    System.out.println(e512.biasedRandom(10, 32));
    System.out.println(e512.biasedRandom(10, 32));
    System.out.println(e512.biasedRandom(10, 32));
    System.out.println(e512.biasedRandom(10, 32));
  }
}