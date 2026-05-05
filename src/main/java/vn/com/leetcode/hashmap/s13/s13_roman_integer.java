package vn.com.leetcode.hashmap.s13;

import vn.com.leetcode.Solution;
import vn.com.leetcode.TestCase;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

record Input(String in) {
}

public class s13_roman_integer extends Solution<Input, Integer> {

    /**
     * Sử dụng hash map
     * @param input
     * @return
     */
    @Override
    public Integer solve(Input input) {
        String in = input.in();

        Map<Character, Integer> mapper = init();

        int result = 0;
        for (int i = 0; i < in.length() - 1; i++) {
            if (mapper.get(in.charAt(i)) < mapper.get(in.charAt(i + 1))) {
                result -= mapper.get(in.charAt(i));
            } else {
                result += mapper.get(in.charAt(i));
            }
        }

        return result + mapper.get(in.charAt(in.length() - 1));
    }

    private Map<Character, Integer> init() {
        Map<Character, Integer> mapper = new HashMap<>();
        mapper.put('I', 1);
        mapper.put('V', 5);
        mapper.put('X', 10);
        mapper.put('L', 50);
        mapper.put('C', 100);
        mapper.put('D', 500);
        mapper.put('M', 1000);
        return mapper;
    }

    @Override
    public List<TestCase<Input, Integer>> testCases() {
        return List.of(
                TestCase.of(new Input("III"), 3),
                TestCase.of(new Input("LVIII"), 58),
                TestCase.of(new Input("MCMXCIV"), 1994)
        );
    }

    public static void main(String[] args) {
        var sol = new s13_roman_integer();
        sol.run();
    }

    /**
     * Sử dụng switch casse thay cho hash map
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        int total = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int currentValue = getValue(s.charAt(i));

            if (currentValue < prevValue) {
                total -= currentValue;
            } else {
                total += currentValue;
            }
            prevValue = currentValue;
        }

        return total;
    }

    private int getValue(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }


}
