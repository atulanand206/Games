package com.games.UVa.P11902;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cases = Integer.parseInt(br.readLine().trim());
    for (int i = 1; i <= cases; i++) {
      int nodes = Integer.parseInt(br.readLine().trim());
      List<String> lines = new ArrayList<>();
      for (int j = 0; j < nodes; j++) {
        lines.add(br.readLine());
      }
      List<List<Integer>> graph = loadGraph(lines);
      printList(graph);
      printCase(i);
      dominator(graph);
    }
  }

  public static void dominator(List<List<Integer>> graph) {
    int size = graph.size();
    printList(graph);
    System.out.println();
    System.out.println(printDividerRow(size));
    for (int j = 0; j < size; j++) {
      List<Boolean> traverse = traverse(graph, size, 0, j);
      List<Boolean> travers = traverse(graph, size, j, j);
      printVisited(traverse);
      printVisited(travers);
      System.out.println(printDividerRow(size));
    }
  }

  private static List<Boolean> traverse(List<List<Integer>> graph, int size, int row, int j) {
    Boolean[] array = new Boolean[size];
    Arrays.fill(array, FALSE);
    List<Boolean> visited = Arrays.asList(array);
    visited.set(j, TRUE);
    dfs(graph, row, j, visited);
    return visited;
  }

  private static void dfs(List<List<Integer>> graph,
                          int row, int stopIndex,
                          List<Boolean> visited) {
    List<Integer> integers = graph.get(row);
    for (int i = 0; i < integers.size(); i++) {
      if (i == stopIndex)
        continue;
      if (integers.get(i).equals(1) && !visited.get(i)) {
        visited.set(i, Boolean.TRUE);
        dfs(graph, i, stopIndex, visited);
      }
    }
  }

  public static List<List<Integer>> loadGraph(List<String> lines) {
    List<List<Integer>> graph = new ArrayList<>();
    for (String line : lines) {
      graph.add(Arrays.stream(line.split(" "))
          .mapToInt(Integer::parseInt)
          .boxed().collect(Collectors.toList()));
    }
    return graph;
  }

  public static void printList(List<List<Integer>> lists) {
    lists.forEach(list -> {
      list.forEach(item -> System.out.printf("%s ", item));
      System.out.println();
    });
  }

  public static void printVisited(List<Boolean> visited) {
    System.out.print("|");
    visited.forEach(visit -> {
      System.out.printf("%s|", visit ? "Y" : "N");
    });
    System.out.println();
  }

  public static String printDividerRow(int size) {
    return "+" + "-".repeat(size * 2 - 1) + "+";
  }

  public static void printCase(int i) {
    System.out.printf("Case %d:\n", i);
  }
}
