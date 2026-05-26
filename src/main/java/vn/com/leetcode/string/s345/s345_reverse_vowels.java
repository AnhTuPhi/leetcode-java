package vn.com.leetcode.string.s345;

import java.util.List;
import vn.com.leetcode.Solution;
import vn.com.leetcode.TestCase;

/**
 * @author: tu.phianh
 * @mail: tu.phianh@ivnd.com.vn
 * @created: 26/05/2026
 */
record Input(String s) {}

public class s345_reverse_vowels extends Solution<Input, String> {

    //nguyên âm: u e o a i
    @Override
    public String solve(Input input) {
        String s = input.s();
        char[] chars = s.toCharArray();
        String vowels = "aeiouAEIOU";

        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (vowels.indexOf(chars[left]) == -1) {
                left++;
            } else if (vowels.indexOf(chars[right]) == -1) {
                right--;
            } else {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }

    @Override
    public List<TestCase<Input, String>> testCases() {
        return List.of(
                TestCase.of(new Input("IceCreAm"), "AceCreIm"),
                TestCase.of(new Input("leetcode"), "leotcede")
        );
    }

    public static void main(String[] args) {
        var sol = new s345_reverse_vowels();
        sol.run();
    }
}
