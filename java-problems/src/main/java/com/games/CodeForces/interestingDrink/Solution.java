package com.games.CodeForces.interestingDrink;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int shops = sc.nextInt();
        List<Integer> rates = new ArrayList<>();

        while (shops-- > 0)
            rates.add(sc.nextInt());
        Collections.sort(rates);
        int q = sc.nextInt();
        while (q-- > 0) {
            int cas = sc.nextInt();
            int start = 0, end = rates.size() - 1, count = 0;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (rates.get(mid) <= cas) {
                    count = mid + 1;
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            System.out.println(count);
        }
    }
}
