package com.games.LeetCode.DecChallenge.MountainArray;

public class Solution {

    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3)
            return false;
        if (arr[0] > arr[1])
            return false;
        boolean isDecreasing = false;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1])
                return false;
            if (arr[i + 1] < arr[i])
                isDecreasing = true;
            if (isDecreasing && arr[i + 1] > arr[i])
                return false;
        }
        return isDecreasing;
    }
}
