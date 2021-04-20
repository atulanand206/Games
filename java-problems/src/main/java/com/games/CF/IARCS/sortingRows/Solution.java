package com.games.CF.IARCS.sortingRows;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int n = sc.nextInt();
        while (n-- > 0) {
            List<Integer> ls = new ArrayList<>();
            int k;
            while ((k = sc.nextInt()) != -1) ls.add(k);
            nums.add(ls);
        }

        for (List<Integer> list : nums) {
            for (int in : list)
                System.out.printf("%d ", in);
            System.out.println();
        }
    }
}
