package vn.com.leetcode.array.string.s55;

import vn.com.leetcode.Solution;
import vn.com.leetcode.TestCase;

import java.util.List;

record Input(int[] nums) {
}

public class s55_jump_game extends Solution<Input, Boolean> {

    @Override
    public Boolean solve(Input input) {
        int[] nums = input.nums();
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false;
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return true;
    }

    @Override
    public List<TestCase<Input, Boolean>> testCases() {
        return List.of(
                TestCase.of(new Input(new int[]{2, 3, 1, 1, 4}), Boolean.TRUE),
                TestCase.of(new Input(new int[]{3, 2, 1, 0, 4}), Boolean.FALSE)
        );
    }

    public static void main(String[] args) {
        var sol = new s55_jump_game();
        sol.run();
    }
}
