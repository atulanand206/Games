package com.games.UVa.P467;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

  static int MAX_TIME = 3600;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = "";
    int caseNo = 1;
    while ((line = br.readLine()) != null)
      printSyncTime(caseNo++, syncTime(line));
  }

  private static void printSyncTime(int caseNo, int syncTimeInSeconds) {
    if (syncTimeInSeconds > MAX_TIME) {
      System.out.printf("Set %d is unable to synch after one hour.", caseNo);
    } else {
      int minutes = syncTimeInSeconds / 60;
      int seconds = syncTimeInSeconds % 60;
      System.out.printf("Set %d synchs again at %d minute(s) and %d second(s) after all turning green.", caseNo, minutes, seconds);
    }
  }

  public static int syncTime(String line) {
    List<Integer> nums = Arrays.stream(line.split(" "))
        .mapToInt(Integer::parseInt)
        .boxed().sorted()
        .collect(Collectors.toList());
    nums.forEach(System.out::println);
    int currentTime = nums.get(0) * 2;
    System.out.println(currentTime);
    while (!allGreens(currentTime, nums) && currentTime <= MAX_TIME)
      currentTime++;
    return currentTime;
  }

  public static boolean allGreens(int currentTime, List<Integer> timings) {
    for (Integer timing : timings) {
      if ((currentTime % (timing * 2)) >= (currentTime % timing - 5))
        return false;
    }
    return false;
  }
}
