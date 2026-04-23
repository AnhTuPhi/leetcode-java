package vn.com.leetcode;

import java.util.*;

public class MyProblem extends Solution<String[], List<List<String>>> {

    @Override
    public List<List<String>> solve(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            map.computeIfAbsent(new String(chars), k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }

    @Override
    public List<TestCase<String[], List<List<String>>>> testCases() {
        return List.of(
                TestCase.of("classic",
                        new String[]{"eat","tea","tan","ate","nat","bat"},
                        List.of(List.of("eat","tea","ate"), List.of("tan","nat"), List.of("bat"))),
                TestCase.of("single",
                        new String[]{"a"},
                        List.of(List.of("a"))),
                TestCase.of("empty strings",
                        new String[]{"",""},
                        List.of(List.of("","")))
        );
    }

    // So sánh không quan tâm thứ tự group và thứ tự trong mỗi group
    @Override
    public boolean assertEquals(List<List<String>> expected, List<List<String>> actual) {
        if (expected.size() != actual.size()) return false;
        Set<Set<String>> expSet = new HashSet<>();
        for (List<String> g : expected) expSet.add(new HashSet<>(g));
        Set<Set<String>> actSet = new HashSet<>();
        for (List<String> g : actual) actSet.add(new HashSet<>(g));
        return expSet.equals(actSet);
    }

    public static void main(String[] args) {
        var sol = new MyProblem();
        sol.run();
        sol.benchmark(100, 1000);
    }
}