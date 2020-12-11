package com.games.LeetCode.Problems.DiscountNOrders;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    static class Cashier {

        private static int orders = 0;
        private int n;
        private final double discountFactor;
        private Map<Integer, Integer> map;


        public Cashier(int n, int discount, int[] products, int[] prices) {
            orders = 0;
            this.n = n;
            this.discountFactor = discount;
            this.map = new HashMap<>();
            for (int i = 0; i < products.length; i++)
                map.put(products[i], prices[i]);
        }

        public double getBill(int[] product, int[] amount) {
            orders = (orders + 1) % n;
            double cost = 0;
            for (int i = 0; i < product.length; i++)
                cost += map.get(product[i]) * amount[i];
            return (orders == 0) ? cost - (cost * discountFactor) / 100f : cost;
        }
    }
}
