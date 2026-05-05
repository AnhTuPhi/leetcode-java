package vn.com.leetcode.string.s14;

import vn.com.leetcode.utils.JsonMapper;

import java.util.Arrays;

public class s14_longest_common_prefix {

    class Solution {
        public String longestCommonPrefix(String[] strings) {
            Arrays.sort(strings);

            String first = strings[0];
            String last = strings[strings.length - 1];
            int index = 0;
            while (index < first.length() && index < last.length()) {
                if (first.charAt(index) == last.charAt(index)) {
                    index++;
                } else {
                    break;
                }
            }

            return first.substring(0, index);
        }
    }
}
