package com.games.UVa.P11902;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.games.UVa.P11902.Main.printList;

class MainTest {

  @Test
  void testLoadGraph() {
    String[] lines = new String[]{
        "0 1 1 0 0",
        "0 0 0 1 0",
        "0 0 0 1 0",
        "0 0 0 0 1",
        "0 0 0 0 0"};
    List<List<Integer>> lists = Main.loadGraph(Arrays.stream(lines).collect(Collectors.toList()));
    printList(lists);
  }

  @Test
  void testDominator() {
    String[] lines = new String[]{
        "0 1 1 0 0",
        "0 0 0 1 0",
        "0 0 0 1 0",
        "0 0 0 0 1",
        "0 0 0 0 0"};
    List<List<Integer>> lists = Main.loadGraph(Arrays.stream(lines).collect(Collectors.toList()));
    Main.dominator(lists);
  }

  @Test
  void testPrintCase() {
    Main.printCase(5);
    Main.printCase(14);
  }

  @Test
  void testPrintDivider() {
    Assertions.assertEquals("+---------+", Main.printDividerRow(5));
    Assertions.assertEquals("+-+", Main.printDividerRow(1));
  }

  @Test
  void testBooleanArray() {
    int size = 5;
    boolean[] array = new boolean[size];
    for (boolean a : array)
      System.out.println(a);
    Arrays.fill(array, false);
    System.out.println();
    for (boolean a : array)
      System.out.println(a);
  }

  @Test
  void testPrintVisited() {
    Boolean[] a = new Boolean[5];
    Arrays.fill(a, Boolean.FALSE);
    List<Boolean> booleans = Arrays.asList(a);
    Main.printVisited(booleans);
    booleans.set(2, Boolean.TRUE);
    System.out.println(Main.printDividerRow(5));
    Main.printVisited(booleans);
  }

}