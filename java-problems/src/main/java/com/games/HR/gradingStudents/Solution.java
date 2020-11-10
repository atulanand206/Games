package com.games.HR.gradingStudents;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public static List<Integer> gradingStudents(List<Integer> grades) {
    List<Integer> roundedGrades = new ArrayList<>();
    for (Integer grade : grades) {
      roundedGrades.add(getRoundedGrade(grade));
    }
    return roundedGrades;
  }

  public static int getRoundedGrade(int grade) {
    if (grade < 38)
      return grade;
    if (grade % 5 >= 3)
      grade += 5 - grade % 5;
    return grade;
  }
}
