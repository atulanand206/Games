package com.games.graph;

import java.util.ArrayList;
import java.util.List;

public class Node {
  int val;
  List<Node> nodeList;

  public Node(int val) {
    this.val = val;
    nodeList = new ArrayList<>();
  }

  public void addNode(Node node) {
    nodeList.add(node);
  }

  public boolean containsNode(int end) {
    for (Node node : nodeList) {
      if (node.val == end)
        return true;
    }
    return false;
  }

  public void removeNode(Node node) {
    nodeList.remove(node);
  }
}
