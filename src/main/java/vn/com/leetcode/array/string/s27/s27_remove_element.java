package vn.com.leetcode.array.string.s27;

import vn.com.leetcode.Solution;
import vn.com.leetcode.TestCase;

import java.util.List;

record Input(int[] nums, int val) {}

public class s27_remove_element extends Solution<Input, int[]> {

    @Override
    public int[] solve(Input input) {
        int[] nums = input.nums();
        int val = input.val();
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }

        return nums;
    }

    /**
     * It does not matter what you leave beyond the returned k (hence they are underscores).
     * @return
     */
    @Override
    public List<TestCase<Input, int[]>> testCases() {
        return List.of(
                TestCase.of("ex 1", new Input(new int[]{3,2,2,3}, 3), new int[]{2,2}),
                TestCase.of("ex 2", new Input(new int[]{0,1,2,2,3,0,4,2}, 2), new int[]{0,1,4,0,3})
        );
    }

    public static void main(String[] args) {
        var sol = new s27_remove_element();
        sol.run();
    }
}
