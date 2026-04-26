package vn.com.leetcode.array.string.s88;

import vn.com.leetcode.Solution;
import vn.com.leetcode.TestCase;
import vn.com.leetcode.utils.JsonMapper;

import java.util.Arrays;
import java.util.List;

record Input(int[] nums1, int m, int[] nums2, int n) {}

public class s88_merge_sorted_array extends Solution<Input, int[]> {

    @Override
    public int[] solve(Input input) {
        int[] nums1 = input.nums1().clone();
        int[] nums2 = input.nums2().clone();
        int m = input.m();
        int n = input.n();

        int i = m - 1;
        int j = n - 1;
        int k = nums1.length - 1;

        while (i >= 0 && j >=0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
        System.out.println(JsonMapper.write(nums1));
        return nums1;
    }

    @Override
    public List<TestCase<Input, int[]>> testCases() {
        return List.of(
                TestCase.of("example 1 - basic merge",
                        new Input(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3), new int[]{1,2,2,3,5,6}),
                TestCase.of("example 2 - nums2 all smaller",
                        new Input(new int[]{1}, 1, new int[]{}, 0), new int[]{1}),
                TestCase.of("example 3 - nums1 empty",
                        new Input(new int[]{0}, 0, new int[]{1}, 1), new int[]{1})
        );
    }

    @Override
    public boolean assertEquals(int[] expected, int[] actual) {
        return Arrays.equals(expected, actual);
    }

    public static void main(String[] args) {
        var sol = new s88_merge_sorted_array();
        sol.run();
        sol.benchmark(100, 1000);
    }
}
