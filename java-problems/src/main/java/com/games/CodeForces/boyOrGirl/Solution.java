package com.games.CodeForces.boyOrGirl;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.stream(new Scanner(new InputStreamReader(System.in)).nextLine().split("")).distinct().count() % 2 == 0 ? "CHAT WITH HER!" : "IGNORE HIM!");
    }
}
