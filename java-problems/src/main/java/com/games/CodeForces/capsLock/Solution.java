package com.games.CodeForces.capsLock;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        String word = new Scanner(new InputStreamReader(System.in)).nextLine();
        if (word.length()>1) {
            if (word.equals(word.toUpperCase()) || word.substring(1).equals(word.substring(1).toUpperCase()))
                System.out.println(word.substring(0,1).toUpperCase()+word.substring(1).toLowerCase());
            else
                System.out.println(word);
        } else if (word.length() == 1) {
            System.out.println(word.toUpperCase());
        }
    }
}
