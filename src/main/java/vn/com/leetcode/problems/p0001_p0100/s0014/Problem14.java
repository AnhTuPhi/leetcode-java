package vn.com.leetcode.problems.p0001_p0100.s0014;

import java.util.Arrays;
import vn.com.leetcode.problems.Problem;

/**
 * @author: tu.phianh
 * @mail: tu.phianh@ivnd.com.vn
 * @created: 24/12/2024
 */
public class Problem14 extends Problem {

    @Override
    public Object solve() {
        var strs = new String[]{"dog","racecar","car"};
        Arrays.sort(strs);

        var first = strs[0];
        var last = strs[strs.length - 1];
        var result = "";
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) == last.charAt(i)) {
                result += first.charAt(i);
            } else {
                break;
            }
        }

        return result;
    }

}
