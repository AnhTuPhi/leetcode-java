package vn.com.leetcode.array.string.s169;

import vn.com.leetcode.Solution;
import vn.com.leetcode.TestCase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

record Input(int[] nums) {}

public class s169_majority_element extends Solution<Input, Integer> {

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
