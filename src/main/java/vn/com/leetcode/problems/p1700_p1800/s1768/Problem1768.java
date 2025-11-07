package vn.com.leetcode.problems.p1700_p1800.s1768;

import vn.com.leetcode.problems.Problem;

/**
 * @author: tu.phianh
 * @mail: tu.phianh@ivnd.com.vn
 * @created: 05/11/2025
 */
public class Problem1768 extends Problem {

    @Override
    public Object solve() {
        return merge("abc", "pqr");
    }

    private String merge(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int index = Math.max(word1.length(), word2.length());

        for (int i = 0; i < index; i++) {
            if (i < word1.length()) {
                result.append(word1.charAt(i));
            }
            if (i < word2.length()) {
                result.append(word2.charAt(i));
            }
        }
        return result.toString();
    }
}
