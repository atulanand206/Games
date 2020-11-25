package com.games.CLRS;

import com.games.graph.Graph;
import com.games.graph.MotherVertex;
import com.games.graph.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.games.graph.GraphUtils.printDfsGraph1Indexed;

class E22_12Test {

  @Test
  void testComputeInDegrees() throws Exception{
    Graph graph = new Graph(8);
    graph.addEdge(1, 2);
    graph.addEdge(2, 4);
    graph.addEdge(3, 6);
    graph.addEdge(2, 3);
    graph.addNode();
    graph.addEdge(7, 8);
    graph.addEdge(8, 6);
    graph.computeInDegrees();
    graph.removeEdge(7, 8);
    graph.removeEdge(2, 8);
    System.out.println();
    graph.computeInDegrees();
  }

  @Test
  void testSwitchAdjacencyListToMatrix() throws Exception {
    Graph graph = new Graph(7);
    graph.addEdge1Indexed(1,2);
    graph.addEdge1Indexed(1,3);
    graph.addEdge1Indexed(2,4);
    graph.addEdge1Indexed(2,5);
    graph.addEdge1Indexed(3,6);
    graph.addEdge1Indexed(3,7);
    graph.printAdjMatrix1Indexed();
  }

  @Test
  void testTranspose() throws Exception {
    Graph graph = new Graph(9);
    graph.addEdge(1, 2);
    graph.addEdge(2, 4);
    graph.addEdge(3, 6);
    graph.addEdge(2, 3);
    graph.addEdge(7, 8);
    graph.addEdge(8, 6);
    graph.printAdjList1Indexed();
    System.out.println();
    graph.printAdjMatrix1Indexed();
    System.out.println();
    graph.printTransposeMatrixFromAdjMatrix();
    System.out.println();
    graph.printTransposeMatrixFromAdjList();
  }

  @Test
  void testDFS() throws Exception {
    Graph graph = new Graph(9);
    graph.addEdge1Indexed(1, 2);
    graph.addEdge1Indexed(2, 4);
    graph.addEdge1Indexed(3, 6);
    graph.addEdge1Indexed(2, 3);
    graph.addEdge1Indexed(7, 8);
    graph.addEdge1Indexed(8, 6);
    printDfsGraph1Indexed(graph.getNodeList());
  }

  @Test
  void testDFS2() throws Exception {
    Graph graph = new Graph(5);
    graph.addEdge(0, 1);
    graph.addEdge(0, 4);
    graph.addEdge(1, 2);
    graph.addEdge(1, 3);
    graph.addEdge(1, 4);
    graph.addEdge(2, 3);
    graph.addEdge(3, 4);
    printDfsGraph1Indexed(graph.getNodeList());
  }

  @Test
  void testMotherVertex() throws Exception {
    Graph graph = new Graph(5);
    graph.addEdge(0, 1);
    graph.addEdge(0, 4);
    graph.addEdge(1, 2);
    graph.addEdge(1, 3);
    graph.addEdge(1, 4);
    graph.addEdge(2, 3);
    graph.addEdge(3, 4);
    graph.adjMatrix();
    List<Node> nodeList = graph.getNodeList();
    Assertions.assertEquals(nodeList.get(0), MotherVertex.motherVertex(nodeList));
  }
}