package com.games.LeetCode.Problems.CourseSchedule;

import java.util.*;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> courses = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int courseToDo = prerequisite[1];
            int courseMustBeDone = prerequisite[0];
            if (isPrerequisiteInvalid(courses, courseToDo, courseMustBeDone))
                return false;
            Set<Integer> set;
            if (!courses.containsKey(courseMustBeDone)) {
                set = new HashSet<>();
            } else {
                set = courses.get(courseMustBeDone);
            }
            set.add(courseToDo);
            courses.put(courseMustBeDone, set);
        }
        return true;
    }

    private boolean isPrerequisiteInvalid(Map<Integer, Set<Integer>> courses, int courseToDo, int courseMustBeDone) {
        if (courses.containsKey(courseToDo)) {
            Set<Integer> set = courses.get(courseToDo);
            if (set.contains(courseMustBeDone))
                return true;
            else {
                for (Integer it : set) {
                    if (isPrerequisiteInvalid(courses, it, courseMustBeDone))
                        return true;
                }
            }
        }
        return false;
    }
}
