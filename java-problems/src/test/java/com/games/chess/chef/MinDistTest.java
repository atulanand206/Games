package com.games.chess.chef;

import com.games.chess.utils.ListUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MinDistTest {

  public static class Point {
    final int x;
    final int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public Double distanceFrom(Point point) {
      return Math.sqrt(Math.pow(x - point.x, 2) + Math.pow(y - point.y, 2));
    }
  }

  public static class Pair {
    final Point p1;
    final Point p2;
    final double distance;

    public Pair(Point p1, Point p2) {
      this.p1 = p1;
      this.p2 = p2;
      distance = p1.distanceFrom(p2);
    }

    public double getDistance() {
      return distance;
    }
  }

  public static class Groups {
    final List<Pair> pairs;
    double distance = 0;

    public Groups(List<Pair> pairs) {
      this.pairs = pairs;
      pairs.forEach(pair -> distance += pair.distance);
    }

    public double getDistance() {
      return distance;
    }
  }

  public static class MinDist {

    final int n;
    final List<Point> points;
    double distance;

    public MinDist(int n, List<Point> points) {
      this.n = n;
      this.points = points;
      distance = calculateMinDist();
    }

    private double calculateMinDist() {
      List<Integer> indices = new ArrayList<>();
      for (int i=0;i<n;i++)
        indices.add(i);
      List<Point> indexes = new ArrayList<>();
      
      return 0;
    }

    public double minDist() {
      return distance;
    }
  }

  @Test
  void testMinDist() {
    int n = 2;
    List<Point> points = new ArrayList<>();
    points.add(new Point(1, 1));
    points.add(new Point(8, 6));
    points.add(new Point(6, 8));
    points.add(new Point(1, 3));
    MinDist minDist = new MinDist(n, points);
    Assertions.assertEquals(4.83, minDist.minDist());
  }
}
