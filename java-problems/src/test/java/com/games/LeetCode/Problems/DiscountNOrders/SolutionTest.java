package com.games.LeetCode.Problems.DiscountNOrders;

import com.games.LeetCode.Problems.DiscountNOrders.Solution.Cashier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void testCashier() {
        Cashier cashier = new Cashier(3, 50, new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{100, 200, 300, 400, 300, 200, 100});
        assertEquals(500, cashier.getBill(new int[]{1, 2}, new int[]{1, 2}));                        // return 500.0, bill = 1 * 100 + 2 * 200 = 500.
        assertEquals(4000, cashier.getBill(new int[]{3, 7}, new int[]{10, 10}));                      // return 4000.0
        assertEquals(800, cashier.getBill(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{1, 1, 1, 1, 1, 1, 1}));    // return 800.0, The bill was 1600.0 but as this is the third customer, he has a discount of 50% which means his bill is only 1600 - 1600 * (50 / 100) = 800.
        assertEquals(4000, cashier.getBill(new int[]{4}, new int[]{10}));                           // return 4000.0
        assertEquals(4000, cashier.getBill(new int[]{7, 3}, new int[]{10, 10}));                      // return 4000.0
        assertEquals(7350, cashier.getBill(new int[]{7, 5, 3, 1, 6, 4, 2}, new int[]{10, 10, 10, 9, 9, 9, 7})); // return 7350.0, Bill was 14700.0 but as the system counted three more customers, he will have a 50% discount and the bill becomes 7350.0
        assertEquals(2500, cashier.getBill(new int[]{2, 3, 5}, new int[]{5, 3, 2}));
    }

}