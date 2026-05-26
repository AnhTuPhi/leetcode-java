package vn.com.leetcode.hashmap.s242;

import vn.com.leetcode.Solution;
import vn.com.leetcode.TestCase;

import java.util.*;

record Input(String s, String t) {}

public class s242_valid_anagram extends Solution<Input, Boolean> {

    /**
     * Not the best solutions. Run test cost 19ms. Top 3 answer solutions
     * Time O(n)
     * Space O(n)
     * @param input
     * @return
     */
    @Override
    public Boolean solve(Input input) {
        String s = input.s();
        String t = input.t();

        if (s.length() != t.length()) return false;

        Map<Character, Integer> mapper = new HashMap<>();
        for (int i =0; i<s.length(); i++) {
            char ch = s.charAt(i);
            mapper.put(ch, mapper.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (!mapper.containsKey(ch) || mapper.get(ch) == 0) return false;
            mapper.put(ch, mapper.get(ch) - 1);
        }

        return true;
    }

    /**
     * Solve by using method of array. Cost around 3-5ms. Top2
     * Time O(n log n)
     * Space O(n)
     *
     * Java dùng thuật toán Dual-Pivot Quicksort cho mảng primitive (char[], int[]...), có độ phức tạp O(n log n).
     * Cả Quicksort và Merge Sort đều O(n log n), dễ hình dung hơn qua Merge Sort:
     * O(n log n) vì sort phải chia nhỏ (log n lần) và duyệt toàn bộ (n lần) ở mỗi bước chia
     * @param s
     * @param t
     * @return
     */
    public boolean solve2(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        return Arrays.equals(sArr, tArr);
    }

    /**
     * Solve by algorithm. Top 1 answer. Cost 0-1ms
     *
     * Time O(n)
     * Space O(n)
     * @param s
     * @param t
     * @return
     */
    public boolean solve3(String s, String t)  {
        return false;
    }

    @Override
    public List<TestCase<Input, Boolean>> testCases() {
        return List.of(
                TestCase.of(new Input("anagram", "nagaram"), true),
                TestCase.of(new Input("rat", "car"), false),
                TestCase.of(new Input("ab", "a"), false)
        );
    }

    public static void main(String[] args) {
        var sol = new s242_valid_anagram();
        sol.run();
    }
}
