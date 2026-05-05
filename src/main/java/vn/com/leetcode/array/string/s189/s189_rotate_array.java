package vn.com.leetcode.array.string.s189;

import vn.com.leetcode.Solution;
import vn.com.leetcode.TestCase;

import java.util.List;

record Input(int[] nums, int k) {}

public class s189_rotate_array extends Solution<Input, int[]> {

    /**
     * Solutions áp dụng two pointer. Sử dụng 1 array phụ, đặt mỗi phần tử vào vị trí (i + k) % n.
     * Độ phức tạp Time: O(n)
     * Độ phức tạp Space: O(n)
     * @param input
     * @return
     */
    @Override
    public int[] solve(Input input) {
        int[] nums = input.nums();
        int k = input.k();

        int n = nums.length;
        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {
            temp[(i + k) % n] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }

        return nums;
    }

    /**
     * Solutions áp dụng Reverse
     * Độ phức tạp Time: O(n)
     * Độ phức tạp Space: O(1)
     * @param
     * @return
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    @Override
    public List<TestCase<Input, int[]>> testCases() {
        return List.of(
                TestCase.of(new Input(new int[]{1,2,3,4,5,6,7}, 3), new int[]{5,6,7,1,2,3,4}),
                TestCase.of(new Input(new int[]{-1,-100,3,99}, 2), new int[]{3,99,-1,-100})
        );
    }
}
