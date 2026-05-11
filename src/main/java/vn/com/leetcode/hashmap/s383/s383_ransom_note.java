package vn.com.leetcode.hashmap.s383;

import vn.com.leetcode.Solution;
import vn.com.leetcode.TestCase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

record Input(String ransomNote, String magazine) {}

public class s383_ransom_note extends Solution<Input, Boolean> {

    @Override
    public Boolean solve(Input input) {
        var ransomNote = input.ransomNote();
        var magazine = input.magazine();

        Map<Character, Integer> map = new HashMap<>();

        for (char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            if (map.getOrDefault(c, 0) == 0) return false;
            map.put(c, map.get(c) - 1);
        }

        return true;
    }

    @Override
    public List<TestCase<Input, Boolean>> testCases() {
        return List.of(
                TestCase.of(new Input("a", "b"), false),
                TestCase.of(new Input("aa", "ab"), false),
                TestCase.of(new Input("aa", "aab"), true)
        );
    }

    public static void main(String[] args) {
        var sol = new s383_ransom_note();
        sol.run();
    }
}