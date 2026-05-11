package vn.com.leetcode.string.s28;

import vn.com.leetcode.Solution;
import vn.com.leetcode.TestCase;

import java.util.List;

record Input(String haystack, String needle) {}

public class s28_first_occurance_in_string extends Solution<Input, Integer> {
    @Override
    public Integer solve(Input input) {
        var haystack = input.haystack();
        var needle = input.needle();

        return haystack.indexOf(needle);
    }

    @Override
    public List<TestCase<Input, Integer>> testCases() {
        return List.of(
                TestCase.of(new Input("sadbutsad", "sad"), 0),
                TestCase.of(new Input("leetcode", "leeto"), -1)
        );
    }

    public static void main(String[] args) {
        var sol = new s28_first_occurance_in_string();
        sol.run();
    }
}
