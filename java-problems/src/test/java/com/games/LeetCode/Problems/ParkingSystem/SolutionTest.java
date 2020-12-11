package com.games.LeetCode.Problems.ParkingSystem;

import com.games.LeetCode.Problems.ParkingSystem.Solution.ParkingSystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void testParkingSystem() {
        ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
        assertTrue(parkingSystem.addCar(1)); // return true because there is 1 available slot for a big car
        assertTrue(parkingSystem.addCar(2)); // return true because there is 1 available slot for a medium car
        assertFalse(parkingSystem.addCar(3)); // return fals because there is no available slot for a small car
        assertFalse(parkingSystem.addCar(1));
    }
}