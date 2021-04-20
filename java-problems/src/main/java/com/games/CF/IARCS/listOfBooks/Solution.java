package com.games.CF.IARCS.listOfBooks;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int n = sc.nextInt();
        List<Integer> books = new ArrayList<>();
        while (n-- > 0) books.add(sc.nextInt());
        List<Integer> borrowed = new ArrayList<>();
        int q = sc.nextInt();
        while (q-- > 0) {
            int v = sc.nextInt() - 1;
            int book = books.get(v);
            borrowed.add(book);
            books.remove(v);
        }
        for (int i : borrowed) System.out.println(i);
    }
}
