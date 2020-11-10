package com.games.HR.countingValleys;

public class Solution {

  public static int countingValleys(String path) {
    return countingValleys(path.length(), path);
  }

  public static int countingValleys(int steps, String path) {
    int valleys = 0;
    int currentAltitude = 0;
    for (char ch : path.toCharArray()) {
      if (ch == 'D')
        currentAltitude--;
      else if (ch == 'U')
        currentAltitude++;
      if (currentAltitude == 0 && ch == 'U')
        valleys++;
    }
    return valleys;
  }
}
