package com.games.LeetCode.Problems.JumpGameII;

import com.games.chess.utils.ListUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] == 0) continue;
            List<Integer> ints = new ArrayList<>();
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j >= nums.length) continue;
                System.out.println(i + j);
                if (i + j == nums.length - 1)
                    ints.add(dp[i + j] + 1);
                if (i + j < nums.length - 1 && dp[i + j] != 0)
                    ints.add(dp[i + j] + 1);
            }
            ListUtils.print(ints);
            if (!ints.isEmpty()) {
                int val = Collections.min(ints);
                System.out.printf("%d : %d, ", nums[i], val);
                dp[i] = val;
            }
        }
        ListUtils.print(dp);
        System.out.println();
        return dp[0];
    }
}
