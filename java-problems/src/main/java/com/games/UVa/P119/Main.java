package com.games.UVa.P119;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = "";
    boolean addSpace = false;
    while ((line = br.readLine()) != null) {
      if (addSpace)
        System.out.println();
      int friendsCount = Integer.parseInt(line);
      Map<String, Integer> map = new HashMap<>();
      String[] friends = br.readLine().split(" ");
      for (String friend : friends)
        map.put(friend, 0);
      for (int i = 0; i < friendsCount; i++) {
        String[] friendSpec = br.readLine().split(" ");
        int give = Integer.parseInt(friendSpec[1]);
        int giveaways = Integer.parseInt(friendSpec[2]);
        int giveaway = (give / (giveaways != 0 ? giveaways : 1)) * (giveaways == 0 ? 0 : 1);
        int given = -1 * giveaway * giveaways;
        map.merge(friendSpec[0], given, Integer::sum);
        for (int j = 3; j < friendSpec.length; j++) {
          map.merge(friendSpec[j], giveaway, Integer::sum);
        }
      }
      for (String friend : friends) System.out.printf("%s %d\n", friend, map.get(friend));
      addSpace = true;
    }
  }
}
