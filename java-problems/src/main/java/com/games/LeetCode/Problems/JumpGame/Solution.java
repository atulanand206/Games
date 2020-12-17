package com.games.LeetCode.Problems.JumpGame;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    boolean[] goodIndices;

    public boolean canJump(int[] nums) {
        goodIndices = new boolean[nums.length];
        Arrays.fill(goodIndices, false);
        goodIndices[nums.length - 1] = true;
        return canJumpBU(nums);
//        if (nums.length == 1)
//            return true;
//        int last = 0;
//        for (int i = nums.length - 2; i >= 0; --i) {
//            last += 1;
//            if (last <= nums[i]) {
//                last = 0;
//            }
//        }
//        return last == 0;
    }

    private boolean canJump(int[] nums, int index) {
        if (goodIndices[index])
            return true;
        if (index == nums.length - 1)
            return true;
        if (nums[index] == 0)
            return false;
        if (nums[index] < nums.length - 3 - index) // 25000   25003-1 == 25002-0 == 25002
            //2    5 -1 == 4 -0 // 3   4-1 = 3
            return false;
        for (int i = nums[index]; i >= 1; i--) {
            if (canJump(nums, index + i)) {
                goodIndices[index + 1] = true;
                return true;
            }
        }
        return false;
    }

    private boolean canJumpBU(int[] nums) {
        for (int j = nums.length - 2; j >= 0; j--) {
            int ju = Math.min(j + nums[j], nums.length - 1);
            for (int i = j + 1; i <= ju; i++) {
                if (goodIndices[i]) {
                    goodIndices[j] = true;
                    break;
                }
            }
        }
        return goodIndices[0];
    }
}
