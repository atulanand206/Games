package com.games.LeetCode.Problems.ParkingSystem;

public class Solution {

    static class ParkingSystem {

        int bigLimit, mediumLimit, smallLimit;
        int bigUsed = 0, mediumUsed = 0, smallUsed = 0;

        public ParkingSystem(int big, int medium, int small) {
            bigLimit = big;
            mediumLimit = medium;
            smallLimit = small;
        }

        public boolean addCar(int carType) {
            switch (carType) {
                case 1:
                    return !(bigLimit <= bigUsed++);
                case 2:
                    return !(mediumLimit <= mediumUsed++);
                case 3:
                    return !(smallLimit <= smallUsed++);
            }
            return false;
        }
    }
}
