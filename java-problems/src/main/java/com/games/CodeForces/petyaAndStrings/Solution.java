package com.games.CodeForces.petyaAndStrings;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        System.out.println(Integer.compare(sc.next().toLowerCase().compareTo(sc.next().toLowerCase()), 0));
    }
}
