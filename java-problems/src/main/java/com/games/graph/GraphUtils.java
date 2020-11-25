package com.games.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphUtils {

  public static List<List<Integer>> adjMatrixFromAdjList(List<Node> nodeList) {
    return adjMatrixFromAdjList(nodeList, false);
  }

  public static List<List<Integer>> transposeMatrixFromAdjList(List<Node> nodeList) {
    return adjMatrixFromAdjList(nodeList, true);
  }

  public static List<List<Integer>> adjMatrixFromAdjList(List<Node> nodeList, boolean transpose) {
    List<List<Integer>> matrix = new ArrayList<>();
    for (int i = 0; i < nodeList.size(); i++) {
      List<Integer> row = new ArrayList<>();
      for (int j = 0; j < nodeList.size(); j++) {
        putEdge(nodeList, row, transpose ? j : i, transpose ? i : j);
      }
      matrix.add(row);
    }
    return matrix;
  }

  public static void putEdge(List<Node> nodeList, List<Integer> row, int i, int j) {
    if (nodeList.get(i).containsNode(j))
      row.add(1);
    else
      row.add(0);
  }

  public static List<List<Integer>> transposeMatrixFromAdjMatrix(List<List<Integer>> matrix) {
    int size = matrix.size();
    List<List<Integer>> transposeMatrix = emptyGraphMatrix(size);
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (matrix.get(i).get(j) == 1)
          transposeMatrix.get(j).set(i, 1);
      }
    }
    return transposeMatrix;
  }

  public static List<List<Integer>> emptyGraphMatrix(int size) {
    List<List<Integer>> transposeMatrix = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      List<Integer> row = new ArrayList<>();
      for (int j = 0; j < size; j++) {
        row.add(0);
      }
      transposeMatrix.add(row);
    }
    return transposeMatrix;
  }

  public static void printMatrix1Indexed(List<List<Integer>> matrix) {
    System.out.print("    ");
    for (int i = 0; i < matrix.size(); i++)
      System.out.printf("%s ", i + 1);
    System.out.println();
    for (int i = 0; i < matrix.size(); i++) {
      List<Integer> row = matrix.get(i);
      System.out.printf("%s : ", i + 1);
      row.forEach(item -> System.out.printf("%s ", item));
      System.out.println();
    }
  }

  public static void printList1Indexed(List<Node> nodeList) {
    nodeList.forEach(node -> {
      System.out.printf("%s : ", node.val + 1);
      node.nodeList.forEach(n -> {
        System.out.printf("%s ", n.val + 1);
      });
      System.out.println();
    });
  }

  public static void printDfsGraph1Indexed(List<Node> nodeList) {
    List<Boolean> visited = new ArrayList<>();
    for (int i = 0; i < nodeList.size(); i++) {
      visited.add(false);
    }
    for (Node node : nodeList) {
      if (!node.nodeList.isEmpty())
        printDfs1Indexed(node, visited);
    }
  }

  private static void printDfs1Indexed(Node node, List<Boolean> visited) {
    int val = node.val;
    if (!visited.get(val)) {
      System.out.printf("%s ", val + 1);
      visited.set(val, true);
      node.nodeList.forEach(item -> {
        printDfs1Indexed(item, visited);
      });
    }
  }

}
