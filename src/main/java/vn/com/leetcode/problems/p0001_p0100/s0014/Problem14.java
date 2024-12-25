package vn.com.leetcode.problems.p0001_p0100.s0014;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;
import vn.com.leetcode.common.JsonMapper;
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
//        return bestSolution(strs);
        return mySolution(strs);
    }

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

//        var result = mySolution(new String[]{"flower","flow","flight"});
        var result = bestSolution(new String[]{"flower","flow","flight"});

        stopWatch.stop();
        System.out.println("Time elapsed: " + stopWatch.getTime(TimeUnit.MICROSECONDS) + " microseconds");
        System.out.println(JsonMapper.readTree(result));
    }

    /**
     * Time complexity: O(n)
     * Cost: 1ms
     * @param strs
     * @return
     */
    private static Object mySolution(String[] strs) {
        Arrays.sort(strs);

        var first = strs[0];
        var last = strs[strs.length - 1];
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                break;
            }
            result.append(first.charAt(i));
        }

        return result.toString();
    }

    /**
     * Time complexity: O(n)
     * Cost: 0ms
     * @param strs
     * @return
     */
    private static Object bestSolution(String[] strs) {
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length - 1];
        int i = 0;
        while (i < s1.length() && i < s2.length()) {
            if (s1.charAt(i) == s2.charAt(i)) {
                i++;
            } else {
                break;
            }
        }
        if (i == 0) {
            return "";
        } else {
            return s1.substring(0, i);
        }
    }
}
