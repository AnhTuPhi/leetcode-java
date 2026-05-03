package vn.com.leetcode.array.string.s80;

import vn.com.leetcode.Solution;
import vn.com.leetcode.TestCase;

import java.util.List;

record Input(int[] nums) {}

public class s80_remove_duplicate_medium extends Solution<Input, int[]> {
    @Override
    public int[] solve(Input input) {
        var nums = input.nums();
        if (nums.length == 0) return new int[]{};

        var i = 1;
        for (int j = 2; j < nums.length; j++) {
            if (nums[j] != nums[i - 1]) {
                i++;
                nums[i] = nums[j];
            }
        }

        i++;
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
        var sol = new s80_remove_duplicate_medium();
        sol.run();
    }
}
