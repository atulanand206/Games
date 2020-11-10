package com.games.UVa.P661;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

  static class Solution {

    boolean isFuseBlown = false;
    int runningCapacity = 0;
    int maxPower = 0;
    int devices = 0;
    int operations = 0;
    int capacity = 0;
    List<Integer> consumptions = new ArrayList<>();
    List<Boolean> states = new ArrayList<>();

    void reset() {
      runningCapacity = 0;
      maxPower = 0;
      devices = 0;
      operations = 0;
      capacity = 0;
      states.clear();
      consumptions.clear();
      isFuseBlown = false;
    }

    void inputState(String line) {
      reset();
      String[] specs = line.split(" ");
      devices = at(specs, 0);
      operations = at(specs, 1);
      capacity = at(specs, 2);
      for (int i = 0; i < devices; i++) {
        consumptions.add(0);
        states.add(false);
      }
    }

    void setupDeviceConsumptions(int[] arr) {
      devices = arr.length;
      consumptions.clear();
      states.clear();
      for (int j : arr) {
        consumptions.add(j);
        states.add(false);
      }
    }

    void handleOperations(int[] arr) {
      operations = arr.length;
      for (int j : arr) {
        if (j < devices)
          if (handleOperation(j)) break;
      }
    }

    private boolean handleOperation(int operation) {
      if (operation > 0) {
        return handleDevice(operation - 1);
      }
      return false;
    }

    private boolean handleDevice(int device) {
      int power = consumptions.get(device);
      boolean newState = !states.get(device);
      states.set(device, newState);
      runningCapacity += newState ? power : -1 * power;
      maxPower = Math.max(maxPower, runningCapacity);
      if (runningCapacity > capacity) {
        isFuseBlown = true;
        return true;
      }
      return false;
    }

    void printResult(int currentCase) {
      if (isFuseBlown) {
        System.out.printf("Sequence %s\nFuse was blown.\n", currentCase);
      } else {
        System.out.printf("Sequence %s\nFuse was not blown.\nMaximal power consumption was %s amperes.\n", currentCase, maxPower);
      }
      System.out.println();
    }

    private int at(String[] ar, int index) {
      return Integer.parseInt(ar[index]);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = "";
    int currentCase = 1;
    while (!(line = br.readLine()).equals("0 0 0")) {
      Solution solution = new Solution();
      solution.inputState(line);
      setupDeviceConsumptions(solution, br);
      handleOperations(solution, br);
      solution.printResult(currentCase);
      currentCase++;
    }
  }

  static void setupDeviceConsumptions(Solution solution, BufferedReader br) throws IOException {
    for (int i = 0; i < solution.devices; i++) {
      solution.consumptions.set(i, Integer.parseInt(br.readLine().trim()));
    }
  }

  static void handleOperations(Solution solution, BufferedReader br) throws IOException {
    for (int i = 0; i < solution.operations; i++) {
      int operation = Integer.parseInt(br.readLine().trim());
      if (solution.handleOperation(operation)) break;
    }
  }
}
