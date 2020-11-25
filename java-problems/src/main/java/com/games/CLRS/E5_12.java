package com.games.CLRS;

import java.util.Random;

public class E5_12 {
  Random random = new Random();

  public float random(int a, int b) {
    if (a == 0 && b == 1)
      return Math.abs(random.nextFloat());
    if (a > b) {
      a ^= b;
      b ^= a;
      a ^= b;
    }
    return (int) ((b - a + 1) * random(0, 1) + a);
  }

  public int biasedRandom(int a, int b) {
    float random = random(a, b);
    int mid = (a + b) / 2;
    return random < mid ? 0 : 1;
  }
}
