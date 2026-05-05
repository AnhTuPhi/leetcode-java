package vn.com.leetcode.string.s58;

import vn.com.leetcode.Solution;
import vn.com.leetcode.TestCase;

import java.util.List;

record Input(String in) {}

public class s58_length_of_last_word extends Solution<Input, Integer> {

    @Override
    public Integer solve(Input input) {
        String in = input.in();

        in = in.trim();
        String[] splits = in.split(" ");
        return splits[splits.length-1].length();
    }

    public int lengthOfLastWord(String s) {
        int length = 0;


        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                length++;
            } else {

                if (length > 0) return length;
            }
        }
        return length;
    }

    @Override
    public List<TestCase<Input, Integer>> testCases() {
        return List.of(
                TestCase.of(new Input("Hello World"), 5),
                TestCase.of(new Input("   fly me   to   the moon  "), 4)
        );
    }

    public static void main(String[] args) {
        var sol = new s58_length_of_last_word();
        sol.run();
    }
}
