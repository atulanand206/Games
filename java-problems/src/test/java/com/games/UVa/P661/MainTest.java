package com.games.UVa.P661;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

  @Test
  void testInput1() {
    Main.Solution solution = new Main.Solution();
    solution.inputState("2 2 10");
    solution.setupDeviceConsumptions(new int[]{5, 7});
    solution.handleOperations(new int[]{1, 2});
    solution.printResult(1);

    solution.inputState("3 6 10");
    solution.setupDeviceConsumptions(new int[]{2, 5, 7});
    solution.handleOperations(new int[]{2, 1, 2, 3, 1, 3});
    solution.printResult(2);
  }

  @Test
  void testInput3() {
    Main.Solution solution = new Main.Solution();
    solution.inputState("12 18 30");
    solution.setupDeviceConsumptions(new int[]{4, 3, 1, 5, 4, 1, 6, 2, 1, 5, 1, 6});
    solution.handleOperations(new int[]{2, 1, 2, 3, 1, 3, 7, 1, 8, 12, 11, 12, 9, 7, 8, 6, 5, 2});
    solution.printResult(3);
  }
}