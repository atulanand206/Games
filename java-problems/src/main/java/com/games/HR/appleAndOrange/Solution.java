package com.games.HR.appleAndOrange;

public class Solution {

  public static void countApplesAndOranges(int houseStart, int houseEnd, int appleLocation, int orangeLocation, int[] apples, int[] oranges) {
    int[] appleDropped = droppedLocation(appleLocation, apples);
    int[] orangeDropped = droppedLocation(orangeLocation, oranges);
    droppedCount(houseStart, houseEnd, appleDropped);
    droppedCount(houseStart, houseEnd, orangeDropped);
  }

  private static void droppedCount(int houseStart, int houseEnd, int[] droppedLocations) {
    int fruitsDropped = 0;
    for (int location : droppedLocations)
      if (isWithin(houseStart, houseEnd, location))
        fruitsDropped++;
    System.out.println(fruitsDropped);
  }

  private static int[] droppedLocation(int treeLocation, int[] dropLengths) {
    int[] droppedLocations = new int[dropLengths.length];
    for (int i = 0; i < dropLengths.length; i++)
      droppedLocations[i] = treeLocation + dropLengths[i];
    return droppedLocations;
  }

  private static boolean isWithin(int houseStart, int houseEnd, int location) {
    return location >= houseStart && location <= houseEnd;
  }
}
