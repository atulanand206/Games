package com.games.LeetCode.Problems.CentennialWheel;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private int personsWaiting = 0;
    private int personsBoarded = 0;
    private List<Integer> costAfterRounds;
    private int round = 0;

    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        this.costAfterRounds = new ArrayList<>();
        boardCustomers(customers, boardingCost, runningCost);
        boardRemainingFolks(boardingCost, runningCost);
        if (costAfterRounds.isEmpty())
            return -1;
        return getMaxIndex();
    }

    private void boardCustomers(int[] customers, int boardingCost, int runningCost) {
        round = 0;
        while (round < customers.length) {
            personsWaiting += customers[round];
            board();
            addCost(boardingCost, runningCost);
        }
    }

    private void boardRemainingFolks(int boardingCost, int runningCost) {
        while (personsWaiting > 0) {
            board();
            addCost(boardingCost, runningCost);
        }
    }

    private void board() {
        int personsPerGondola = 4;
        if (personsWaiting >= personsPerGondola) {
            personsWaiting -= personsPerGondola;
            personsBoarded += personsPerGondola;
        } else {
            personsBoarded += personsWaiting;
            personsWaiting = 0;
        }
    }

    private void addCost(int boardingCost, int runningCost) {
        costAfterRounds.add(personsBoarded * boardingCost - (round++ + 1) * runningCost);
    }

    private int getMaxIndex() {
        int i;
        int maxIndex = -1;
        int maxValue = 0;
        for (i = 0; i < costAfterRounds.size(); i++) {
            if (costAfterRounds.get(i) > maxValue && costAfterRounds.get(i) > 0) {
                maxValue = costAfterRounds.get(i);
                maxIndex = (i + 1);
            }
        }
        return maxIndex;
    }
}
