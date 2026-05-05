package vn.com.leetcode.array.string.s121;

import vn.com.leetcode.Solution;
import vn.com.leetcode.TestCase;

import java.util.HashMap;
import java.util.List;

record Input(int[] prices) {
}

public class s121_best_time_buy_sell_stock extends Solution<Input, Integer> {
    @Override
    public Integer solve(Input input) {
        int[] prices = input.prices();

        int buyPrice = prices[0];
        int profit = 0;

        for (var price : prices) {
            if (price < buyPrice) {
                buyPrice = price;
            } else {
                profit = Math.max(profit, price - buyPrice);
            }
        }

        return profit;
    }

    public Integer solve2(Input input) {
        int[] prices = input.prices();

        int currentProfit = 0;
        int maxProfit = 0;

        for (int i =1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            currentProfit = Math.max(0, currentProfit + diff);
            maxProfit = Math.max(maxProfit, currentProfit);
        }

        return maxProfit;
    }

    @Override
    public List<TestCase<Input, Integer>> testCases() {
        return List.of(
                TestCase.of(new Input(new int[]{7, 1, 5, 3, 6, 4}), 5),
                TestCase.of(new Input(new int[]{7, 6, 4, 3, 1}), 0)
        );
    }
}
