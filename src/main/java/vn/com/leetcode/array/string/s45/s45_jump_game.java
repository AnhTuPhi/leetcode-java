package vn.com.leetcode.array.string.s45;

import vn.com.leetcode.Solution;
import vn.com.leetcode.TestCase;

import java.util.List;

record Input(int[] nums) {
}

public class s45_jump_game extends Solution<Input, Integer> {

    @Override
    public Integer solve(Input input) {
        int[] nums = input.nums();

        int jumps = 0;
        int current = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (i == current) {
                jumps++;
                current = farthest;
            }

            if (current == nums.length - 1) {
                break;
            }
        }

        return jumps;
    }

    @Override
    public List<TestCase<Input, Integer>> testCases() {
        return List.of(
                TestCase.of(new Input(new int[]{2, 3, 1, 1, 4}), 2),
                TestCase.of(new Input(new int[]{2, 3, 0, 1, 4}), 2)
        );
    }

    public static void main(String[] args) {
        var sol = new s45_jump_game();
        sol.run();
    }
}
