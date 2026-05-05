package vn.com.leetcode.array.string.s169;

import vn.com.leetcode.Solution;
import vn.com.leetcode.TestCase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

record Input(int[] nums) {}

public class s169_majority_element extends Solution<Input, Integer> {

    /**
     * Solutions áp dụng Hashmap để count số lần lặp khi loop
     * Độ phức tạp Time: O(n)
     * Độ phức tạp Space: O(n)
     * Vì n càng tăng thì cost là n => tăng tuyến tính theo
     * @param input
     * @return
     */
    @Override
    public Integer solve(Input input) {
        int[] nums = input.nums();
        int n = nums.length;
        int index = n / 2;

        Map<Integer, Integer> mapper = new HashMap<>();

        for (int i = 0; i < n; i++) {
            Integer key = mapper.getOrDefault(nums[i], null);
            if (Objects.isNull(key)) {
                mapper.put(nums[i], 1);
            } else {
                key++;
                mapper.put(nums[i], key);
            }
        }

        for (Map.Entry<Integer, Integer> entry : mapper.entrySet()) {
            if (entry.getValue() > index) return entry.getKey();
        }

        return 0;
    }

    /**
     * Solutions áp dụng Boyer Moore Voting Algorithm
     * Độ phức tạp Time: O(n)
     * Độ phức tạp Space: O(1)
     * @param input
     * @return
     */
    public Integer solve2(Input input) {
        int[] nums = input.nums();
        int vote = 0;
        int candidate = 0;

        for (int num : nums) {
            if (vote == 0) {
                candidate = num;
            }

            if (candidate == num) {
                vote++;
            } else {
                vote--;
            }
        }

        return candidate;
    }

    @Override
    public List<TestCase<Input, Integer>> testCases() {
        return List.of(
                TestCase.of(new Input(new int[]{3,2,3}), 3),
                TestCase.of(new Input(new int[]{2,2,1,1,1,2,2}), 2)
        );
    }

    public static void main(String[] args) {
        var sol = new s169_majority_element();
        sol.run();
    }
}
