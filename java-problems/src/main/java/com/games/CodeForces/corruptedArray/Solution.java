package com.games.CodeForces.corruptedArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            List<Integer> nums = intList(br.readLine().split(" "));
            Collections.sort(nums);
            long sum = 0;
            int size = nums.size();
            for (int i = 0; i < size - 1; i++) {
                sum += nums.get(i);
            }
            if (sum - nums.get(size - 2) == nums.get(size - 2)) {
                nums = nums.subList(0, size - 2);
                for (int i : nums)
                    System.out.printf("%d ", i);
                System.out.println();
                continue;
            }

            boolean done = false;
            for (int i = 0; i < size - 1; i++) {
                if (sum - nums.get(i) == nums.get(size - 1)) {
                    nums.remove(i);
                    nums.remove(nums.size() - 1);
                    for (int j : nums)
                        System.out.printf("%d ", j);
                    System.out.println();
                    done = true;
                    break;
                }
            }
            if (!done) System.out.println(-1);
        }
    }

    public static List<Integer> intList(String[] list) {
        List<Integer> result = new ArrayList<>();
        for (String str : list)
            result.add(Integer.parseInt(str));
        return result;
    }
}
