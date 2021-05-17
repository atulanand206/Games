package com.games.CodeForces.doNotBeDistracted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            char lastTask = ' ';
            Set<Character> tasksDone = new HashSet<>();
            char[] tasks = br.readLine().toCharArray();
            boolean suspicious = false;
            for (char task : tasks) {
                if (lastTask == task) continue;
                if (tasksDone.contains(task)) {
                    suspicious = true;
                    break;
                }
                tasksDone.add(task);
                lastTask = task;
            }
            System.out.println(!suspicious ? "YES" : "NO");
        }
    }
}
