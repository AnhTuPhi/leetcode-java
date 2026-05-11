package vn.com.leetcode.array.string.s45;

import vn.com.leetcode.Solution;
import vn.com.leetcode.TestCase;

import java.util.List;

record Input(int[] nums) {}

public class s45_jump_game extends Solution<Input, Integer> {

    @Override
    public Integer solve(Input input) {
        int[] nums = input.nums();

        return 0;
    }

    @Override
    public List<TestCase<Input, Integer>> testCases() {
        return List.of(
                TestCase.of(new Input(new int[]{2,3,1,1,4}), 2),
                TestCase.of(new Input(new int[]{2,3,0,1,4}), 2)
        );
    }

    public static void main(String[] args) {
        var sol = new s45_jump_game();
        sol.run();
    }
}
