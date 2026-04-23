package vn.com.leetcode;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Input record bundles multiple params into one generic slot
record TwoSumInput(int[] nums, int target) {}

public class TwoSum extends Solution<TwoSumInput, int[]> {

    @Override
    public int[] solve(TwoSumInput input) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < input.nums().length; i++) {
            int complement = input.target() - input.nums()[i];
            if (seen.containsKey(complement)) {
                return new int[]{seen.get(complement), i};
            }
            seen.put(input.nums()[i], i);
        }
        return new int[]{};
    }

    @Override
    public List<TestCase<TwoSumInput, int[]>> testCases() {
        return List.of(
                TestCase.of("basic",   new TwoSumInput(new int[]{2, 7, 11, 15}, 9),  new int[]{0, 1}),
                TestCase.of("middle",  new TwoSumInput(new int[]{3, 2, 4}, 6),        new int[]{1, 2}),
                TestCase.of("same",    new TwoSumInput(new int[]{3, 3}, 6),           new int[]{0, 1})
        );
    }

    // Arrays need custom equality
    @Override
    public boolean assertEquals(int[] expected, int[] actual) {
        return Arrays.equals(expected, actual);
    }

    public static void main(String[] args) {
        TwoSum sol = new TwoSum();
        sol.run();                        // run + verify
        sol.benchmark(100, 1000);         // warmup=100, iterations=1000
    }
}
