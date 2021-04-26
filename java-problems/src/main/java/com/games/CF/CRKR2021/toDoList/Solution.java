package com.games.CF.CRKR2021.toDoList;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int n = sc.nextInt(), x = sc.nextInt();
        int s = 0;
        while (n-- > 0) s += sc.nextInt();
        System.out.println(s + x <= 24 ? "YES" : "NO");
    }
}
