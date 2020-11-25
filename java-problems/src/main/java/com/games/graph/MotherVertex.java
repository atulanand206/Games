package com.games.graph;

import java.util.List;

public class MotherVertex {
  public static Node motherVertex(List<Node> nodeList) {
    boolean[] visited = new boolean[nodeList.size()];
    for (int i = 0; i < nodeList.size(); i++) {
      dfs(nodeList, i, visited);
    }
    return nodeList.get(0);
  }

  private static boolean[] dfs(List<Node> nodeList, int i, boolean[] visited) {
    Node tNode = nodeList.get(i);
    for (int j = 0; j < tNode.nodeList.size(); j++) {
      Node node = nodeList.get(j);
      if (!visited[j]) {
        visited[j] = true;
        return dfs(nodeList, j, visited);
      }

    }
    return visited;
  }
}
