package vn.com.leetcode.hashmap.s1;

import vn.com.leetcode.Solution;
import vn.com.leetcode.TestCase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

record Input(int[] nums, int target) {
}

public class s1_two_sum extends Solution<Input, int[]> {
    @Override
    public int[] solve(Input input) {
        var nums = input.nums();
        var target = input.target();

        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (seen.containsKey(complement)) {
                return new int[]{seen.get(complement), i};
            }
            seen.put(nums[i], i);
        }
        return new int[]{};
    }

    @Override
    public List<TestCase<Input, int[]>> testCases() {
        return List.of(
                TestCase.of(new Input(new int[]{2, 7, 11, 15}, 9), new int[]{0, 1}),
                TestCase.of(new Input(new int[]{3, 2, 4}, 6), new int[]{1, 2}),
                TestCase.of(new Input(new int[]{3, 3}, 6), new int[]{0, 1})
        );
    }

    public static void main(String[] args) {
        var sol = new s1_two_sum();
        sol.run();
    }
}
