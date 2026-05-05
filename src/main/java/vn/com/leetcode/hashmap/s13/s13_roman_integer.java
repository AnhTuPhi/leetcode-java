package vn.com.leetcode.hashmap.s13;

import vn.com.leetcode.Solution;
import vn.com.leetcode.TestCase;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

record Input(String in) {}

public class s13_roman_integer extends Solution<Input, Integer> {
    @Override
    public Integer solve(Input input) {
        String in = input.in();

        Map<Character, Integer> mapper = new HashMap<>();
        mapper.put('I', 1);
        mapper.put('V', 5);
        mapper.put('X', 10);
        mapper.put('L', 50);
        mapper.put('C', 100);
        mapper.put('D', 500);
        mapper.put('M', 1000);

        int result = 0;
        for (int i=0; i< in.length() - 1; i++) {
            if (mapper.get(in.charAt(i)) < mapper.get(in.charAt(i + 1))) {
                result = result - mapper.get(in.charAt(i));
            } else {
                result = result + mapper.get(in.charAt(i));
            }
        }

        return result;
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
        String in = "III";
        Map<Character, Integer> mapper = new HashMap<>();
        mapper.put('I', 1);
        mapper.put('V', 5);
        mapper.put('X', 10);
        mapper.put('L', 50);
        mapper.put('C', 100);
        mapper.put('D', 500);
        mapper.put('M', 1000);

        int result = 0;
        for (int i=0; i< in.length() - 1; i++) {
            System.out.println(i);
            if (mapper.get(in.charAt(i)) < mapper.get(in.charAt(i + 1))) {
                result = result - mapper.get(in.charAt(i));
            } else {
                result = result + mapper.get(in.charAt(i));
            }
        }
        System.out.println(result + mapper.get(in.charAt(in.length() - 1)));
    }

    class Solution {
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
            switch (c) {
                case 'I': return 1;
                case 'V': return 5;
                case 'X': return 10;
                case 'L': return 50;
                case 'C': return 100;
                case 'D': return 500;
                case 'M': return 1000;
                default: return 0;
            }
        }
    }

}
