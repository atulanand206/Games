package com.games.UVa.P414;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while (!(line = br.readLine()).equals("0")) {
      int lines = Integer.parseInt(line.trim());
      List<String> strings = new ArrayList<>();
      for (int i = 0; i < lines; i++)
        strings.add(br.readLine());
      int totalSpaces = getTotalSpaces(strings);
      System.out.println(totalSpaces);
    }
  }

  public static int getTotalSpaces(List<String> strings) {
    List<List<Character>> charArrays = new ArrayList<>();
    for (String string : strings)
      charArrays.add(string.chars()
          .mapToObj(e -> (char) e)
          .collect(Collectors.toList()));
    List<Integer> spaces = new ArrayList<>();
    charArrays.forEach(characters -> {
      spaces.add((int) characters.stream()
          .filter(character -> character.equals(' ') || character.equals('B'))
          .count());
    });
    int minSpaces = Collections.min(spaces);
    return spaces.stream().mapToInt(s -> s - minSpaces).sum();
  }
}
