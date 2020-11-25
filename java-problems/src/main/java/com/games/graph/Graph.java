package com.games.graph;

import java.util.ArrayList;
import java.util.List;

import static com.games.graph.GraphUtils.adjMatrixFromAdjList;
import static com.games.graph.GraphUtils.printList1Indexed;
import static com.games.graph.GraphUtils.printMatrix1Indexed;
import static com.games.graph.GraphUtils.transposeMatrixFromAdjList;
import static com.games.graph.GraphUtils.transposeMatrixFromAdjMatrix;

public class Graph {
  int vertices;
  boolean firstNodeAdded = false;
  List<Node> nodeList;
  Node rootNode;

  List<List<Integer>> matrix = new ArrayList<>();

  public Graph(int vertices) {
    this.vertices = vertices;
    nodeList = new ArrayList<>();
    for (int i = 0; i < vertices; i++) {
      nodeList.add(new Node(i));
    }
  }

  public List<Node> getNodeList() {
    return nodeList;
  }

  public List<List<Integer>> getMatrix() {
    return matrix;
  }

  public void addNode() {
    nodeList.add(new Node(vertices++));
  }

  public void addFirstEdge(int root) {
    rootNode = nodeList.get(root);
    firstNodeAdded = true;
  }

  public void addEdge(int start, int end) throws Exception {
    if (!firstNodeAdded)
      addFirstEdge(start);
    if (nodeList.size() <= start || nodeList.size() <= end) {
      throw new Exception(String.format("Atleast one of the indices %d, %d not available in the graph.", start, end));
    }
    Node node = nodeList.get(start);
    if (!node.containsNode(end)) {
      node.addNode(nodeList.get(end));
    }
  }

  public void addEdge1Indexed(int start, int end) throws Exception {
    addEdge(start - 1, end - 1);
  }

  public void removeEdge(int start, int end) {
    Node node = nodeList.get(start);
    if (node.containsNode(end)) {
      node.removeNode(nodeList.get(end));
    }
  }

  public void computeInDegrees() {
    nodeList.forEach(node -> {
      System.out.printf("%s : %s\n", node.val, node.nodeList.size());
    });
  }

  public void computeInDegrees1Indexed() {
    nodeList.forEach(node -> {
      System.out.printf("%s : %s\n", node.val + 1, node.nodeList.size());
    });
  }

  public void printAdjList() {
    nodeList.forEach(node -> {
      System.out.printf("%s : ", node.val);
      node.nodeList.forEach(n -> {
        System.out.printf("%s ", n.val);
      });
      System.out.println();
    });
  }

  public void printAdjList1Indexed() {
    printList1Indexed(nodeList);
  }

  public void adjMatrix() {
    matrix = adjMatrixFromAdjList(nodeList);
  }

  public void printTransposeMatrixFromAdjMatrix() {
    adjMatrix();
    printMatrix1Indexed(transposeMatrixFromAdjMatrix(matrix));
  }

  public void printTransposeMatrixFromAdjList() {
    printMatrix1Indexed(transposeMatrixFromAdjList(nodeList));
  }

  public void printAdjMatrix1Indexed() {
    adjMatrix();
    printMatrix1Indexed(matrix);
  }

  public Node rootNode() {
    return rootNode;
  }
}
