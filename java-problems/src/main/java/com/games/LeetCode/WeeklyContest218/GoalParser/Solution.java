package com.games.LeetCode.WeeklyContest218.GoalParser;

public class Solution {

    public String interpret(String command) {
        return command.replace("()", "o").replace("(al)", "al");
    }
}
