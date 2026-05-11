package vn.com.leetcode.hashmap.s205;

import vn.com.leetcode.Solution;
import vn.com.leetcode.TestCase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

record Input(String s, String t) {}

public class s205_isomorphic_string extends Solution<Input, Boolean> {
    @Override
    public Boolean solve(Input input) {
        var s = input.s();
        var t = input.t();

        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();

        for(int i=0; i< s.length(); i++){
            if (!m1.containsKey(s.charAt(i))) {
                m1.put(s.charAt(i), i);
            }

            if (!m2.containsKey(t.charAt(i))) {
                m2.put(t.charAt(i), i);
            }

            if (!m1.get(s.charAt(i)).equals(m2.get(t.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public List<TestCase<Input, Boolean>> testCases() {
        return List.of(
                TestCase.of(new Input("egg", "add"), true),
                TestCase.of(new Input("f11", "b23"), false),
                TestCase.of(new Input("paper", "title"), true)
        );
    }

    public static void main(String[] args) {
        var sol = new s205_isomorphic_string();
        sol.run();
    }
}