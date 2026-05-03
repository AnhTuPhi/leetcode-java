package vn.com.leetcode.array.string.s26;

import vn.com.leetcode.Solution;
import vn.com.leetcode.TestCase;

import java.util.List;

record Input(int[] nums) {}

public class s26_remove_duplicate extends Solution<Input, int[]> {
    @Override
    public int[] solve(Input input) {
        var nums = input.nums();
        var i = 0;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return nums;
    }

    @Override
    public List<TestCase<Input, int[]>> testCases() {
        return List.of(
                TestCase.of("ex 1", new Input(new int[]{1,1,2}), new int[]{1,2}),
                TestCase.of("ex 2", new Input(new int[]{0,0,1,1,1,2,2,3,3,4}), new int[]{0,1,2,3,4})
        );
    }

    public static void main(String[] args) {
        var sol = new s26_remove_duplicate();
        sol.run();
    }
}
