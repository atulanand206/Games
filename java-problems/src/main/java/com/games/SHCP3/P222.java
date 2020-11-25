package com.games.SHCP3;

public class P222 {

  public static int P2221(int s, int n) {
    return (s & (n - 1));
  }

  public static boolean P2222(int v) {
    if (v == 0)
      return false;
    return v == 1 || ((v & (v - 1)) == 0);
  }

  public static boolean areAllZeroes(int a, int b, int c) {
    return (a | b | c) == 0;
  }

  public static boolean isOneZero(int a, int b) {
    return ((~a) ^ (~b)) != 0;
  }

  public static boolean atLeastOneZero(int a, int b, int c) {
    return a * b * c == 0;
  }

  public static int nextEven(int x) {
    return x + 2 - (x & 1);
  }

  public static int[] swap(int a, int b) {
    a ^= b;
    b ^= a;
    a ^= b;
    return new int[] {a, b};
  }

  public static boolean bitSubset(int a, int b) {
    return ((a & b) == a);
  }
}
