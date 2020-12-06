package com.games.LeetCode.DecChallenge.KthFactor;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int kthFactor(int n, int k) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= n && factors.size() != k; i++)
            if (n % i == 0)
                factors.add(i);
        if (factors.size() >= k)
            return factors.get(k - 1);
        return -1;
    }
}
