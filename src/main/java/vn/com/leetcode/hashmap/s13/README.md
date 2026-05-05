# 13. Roman to Integer
**Difficulty:** Easy
**Topic:** Hash Table, Math, String
**Company:** Amazon, Google, Microsoft, Apple, Bloomberg, Facebook

## Problem

Roman numerals are represented by seven different symbols:

| Symbol | Value |
|---|---|
| I | 1 |
| V | 5 |
| X | 10 |
| L | 50 |
| C | 100 |
| D | 500 |
| M | 1000 |

Roman numerals are usually written **largest to smallest from left to right**. However, there are **six instances** where subtraction is used:

- `I` can be placed before `V` (5) and `X` (10) to make **4** and **9**
- `X` can be placed before `L` (50) and `C` (100) to make **40** and **90**
- `C` can be placed before `D` (500) and `M` (1000) to make **400** and **900**

Given a roman numeral, convert it to an integer.

## Examples

**Example 1:**
```
Input: s = "III"
Output: 3
Explanation: III = 3.
```

**Example 2:**
```
Input: s = "LVIII"
Output: 58
Explanation: L = 50, V = 5, III = 3.
```

**Example 3:**
```
Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90, IV = 4.
```

## Constraints

- `1 <= s.length <= 15`
- `s` contains only the characters `('I', 'V', 'X', 'L', 'C', 'D', 'M')`
- It is **guaranteed** that `s` is a valid roman numeral in the range `[1, 3999]`

## Cách giải
Có thể áp dụng hash map hoặc switch case để đưa về dạng key value để mapping giá trị.
Từ input là một string để ý là nếu phần tử sau có giá trị thấp hơn thì giá trị sẽ bị trừ và ngược lại.

Ứng dụng hash map
=> space mất công lưu thêm hash map
```java

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
```

Thay vì tạo hash map, có thể dùng luôn switch case đỡ tốn bộ nhớ lưu thêm
```java
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
```