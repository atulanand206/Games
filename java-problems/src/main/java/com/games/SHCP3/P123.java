package com.games.SHCP3;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class P123 {

  static void P1231() {
    Scanner scanner = new Scanner(System.in);
    System.out.printf("%7.3f", scanner.nextDouble());
  }

  static void P1232() {
    Scanner scanner = new Scanner(System.in);
    System.out.printf("%." + scanner.nextInt() + "f", Math.acos(-1));
  }

  static void P1233() {
    Calendar calendar = Calendar.getInstance();
    calendar.set(2020, Calendar.NOVEMBER, 3);
    System.out.println(calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault()));
  }

  static void P1234() {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    List<Integer> list = new ArrayList<>();
    while (n-- > 0) {
      list.add(scanner.nextInt());
    }
    Collections.sort(list);
    for (Integer in : list)
      System.out.print(in + " ");
    System.out.println();
  }

  static class Birthday {
    int mm, dd, yyyy;

    public Birthday(int mm, int dd, int yyyy) {
      this.mm = mm;
      this.dd = dd;
      this.yyyy = yyyy;
    }

    @Override
    public String toString() {
      return "Birthday{" + "dd=" + dd + ", mm=" + mm + ", yyyy=" + yyyy + '}';
    }
  }

  static void P1235() {
    List<Birthday> birthdays = new ArrayList<>();
    birthdays.add(new Birthday(5, 24, 1982));
    birthdays.add(new Birthday(11, 13, 1983));
    birthdays.add(new Birthday(4, 24, 1980));
    birthdays.sort((o1, o2) -> {
      if (o1.mm < o2.mm)
        return 1;
      if (o1.dd < o2.dd)
        return 1;
      if (o1.yyyy > o2.yyyy)
        return 1;
      return 0;
    });
    for (Birthday birthday : birthdays)
      System.out.println(birthday);
  }

  static void P1236() {
    List<Integer> numbers = new ArrayList<>();
    for (int i = 0; i < 1000000; i++)
      numbers.add((int) (Math.random() * 100000));
    int l = 0, r = numbers.size();
    int m = (l + r) / 2;
    int numberToFind = numbers.get(2000);
    int iterations = 0;
    Collections.sort(numbers);
    while (l < m && m < r) {
      Integer integer = numbers.get(m);
      if (integer == numberToFind) {
        break;
      }
      if (integer > numberToFind) {
        l = m;
      } else {
        r = m;
      }
      m = (l + r) / 2;
      iterations++;
    }
    System.out.println(iterations);
  }

  static void P1237() {
    char[] chars = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};

    int i4 = 1022000;
    printBin(i4);
//    i4 |= 1 << 4;
    printBin(i4);
//    i4 &= ~(1 << 4);
    printBin(i4);
    printBin(-i4);
    int i5 = i4 & (-i4);
    printBin((1 << 8) - 1);
    printBin(i5);
//    int k = i4 & (1 << 4);
//    boolean p = k == (1 << 4);
//    System.out.println(p);
//    printBin(0xACD);
//    printBin(0xACD << 2);
//    printBin(0xAB);
  }

  private static void printBin(int i) {
    System.out.println(i + " : " + Integer.toBinaryString(i));
  }

  static void P1238() {
    int size = 20;
    List<Integer> integers = generateList(size);
    List<List<Integer>> subsets = generateSubsets(integers, size);
    printSubsets(subsets);
    System.out.println(subsets.size());
  }

  private static List<Integer> generateList(int size) {
    List<Integer> integers = new ArrayList<>();
    for (int i = 0; i < size; i++)
      integers.add(i);
    return integers;
  }

  private static List<List<Integer>> generateSubsets(List<Integer> integers, int size) {
    List<List<Integer>> subsets = new ArrayList<>();
    for (int i = 0; i < (1 << size); i++) {
      List<Integer> subset = new ArrayList<>();
      for (int j = 0; j < size; j++) {
        if ((i & (1 << j)) != 0) {
          subset.add(integers.get(j));
        }
      }
      subsets.add(subset);
    }
    return subsets;
  }

  private static void printSubsets(List<List<Integer>> subsets) {
    for (int i = 0; i < subsets.size(); i++) {
      List<Integer> subset = subsets.get(i);
      StringBuilder stringBuilder = new StringBuilder(i + ": ");
      for (Integer ints : subset) {
        stringBuilder.append(ints).append(", ");
      }
      int i1 = stringBuilder.lastIndexOf(", ");
      if (i1 >= 0 && i1 + 1 < stringBuilder.length())
        stringBuilder.delete(i1, i1 + 1);
      System.out.println(stringBuilder.toString());
    }
  }

  static void P12310() {
    String text = "a70z72aa24a872";
    String oneAlphaFollowedByTwoNumbers = "[a-z]{1}[0-9]{2}";
    String twoAlphaFollowedByTwoNumbers = "[a-z]{2}[0-9]{2}";
    String oneAlphaFollowedByThreeNumbers = "[a-z]{1}[0-9]{3}";

  }

  public static void main(String[] args) {
    long time = getTimeInMillis();
    P1238();
    long newTime = getTimeInMillis();
    System.out.printf("Time: %s\n", newTime - time);
  }

  private static long getTimeInMillis() {
    return Calendar.getInstance().getTimeInMillis();
  }
}
