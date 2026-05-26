package vn.com.leetcode.hashmap.s290;

import vn.com.leetcode.Solution;
import vn.com.leetcode.TestCase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

record Input(String pattern, String s) {}
public class s290_word_pattern extends Solution<Input, Boolean> {
    @Override
    public Boolean solve(Input input) {
        var pattern = input.pattern();
        var s = input.s();

        String[] words = s.split(" ");

        if (pattern.length() != words.length) return false;

        Map<Character, String> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            if (!map.containsKey(c)) {
                // prevent two chars mapping to the same word (bijection)
                if (map.containsValue(word)) return false;
                map.put(c, word);
            } else {
                if (!map.get(c).equals(word)) return false;
            }
        }

        return true;
    }

    @Override
    public List<TestCase<Input, Boolean>> testCases() {
        return List.of(
                TestCase.of(new Input("abba", "dog cat cat dog"), true),
                TestCase.of(new Input("abba", "dog cat cat fish"), false),
                TestCase.of(new Input("aaaa", "dog cat cat dog"), false)
        );
    }

    public static void main(String[] args) {
        var sol = new s290_word_pattern();
        sol.run();
    }
}
