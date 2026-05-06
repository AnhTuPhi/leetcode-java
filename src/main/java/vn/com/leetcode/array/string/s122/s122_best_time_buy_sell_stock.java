package vn.com.leetcode.array.string.s122;

import vn.com.leetcode.Solution;
import vn.com.leetcode.TestCase;

import java.util.List;

record Input(int[] prices) {
}

public class s122_best_time_buy_sell_stock extends Solution<Input, Integer> {

    @Override
    public Integer solve(Input input) {
        int[] prices = input.prices();
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff >= 0) {
                maxProfit += diff;
            }
        }

        return maxProfit;
    }

    @Override
    public List<TestCase<Input, Integer>> testCases() {
        return List.of(
                TestCase.of(new Input(new int[]{7, 1, 5, 3, 6, 4}), 7),
                TestCase.of(new Input(new int[]{1, 2, 3, 4, 5}), 4),
                TestCase.of(new Input(new int[]{7, 6, 4, 3, 1}), 0)
        );
    }

    public static void main(String[] args) {
        var sol = new s122_best_time_buy_sell_stock();
        sol.run();
    }
}
