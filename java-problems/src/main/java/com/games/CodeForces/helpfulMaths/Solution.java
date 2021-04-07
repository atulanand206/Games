package com.games.CodeForces.helpfulMaths;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.stream(new Scanner(new InputStreamReader(System.in)).nextLine().split("[+]")).sorted().collect(Collectors.joining("+")));
    }
}
