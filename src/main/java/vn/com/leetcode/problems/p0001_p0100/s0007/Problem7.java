package vn.com.leetcode.problems.p0001_p0100.s0007;

/**
 * @author: tu.phianh
 * @mail: tu.phianh@ivnd.com.vn
 * @created: 26/12/2024
 */
public class Problem7 {

    public static void main(String[] args) {
        System.out.println(reverseInteger(1534236469));
        System.out.println(bestReverseInteger(1534236469));
    }

    private static int reverseInteger(int num) {
        int reverse = 0;
        while (num != 0) {
            int pop = num % 10;
            num /= 10;

            if (reverse < Integer.MIN_VALUE / 10 || reverse > Integer.MAX_VALUE / 10) {
                return 0;
            }
            reverse = reverse * 10 + pop;
        }
        return reverse;
    }

    private static int bestReverseInteger(int num) {
        int inverse = 0;
        while(num != 0)
        {
            if (num < 0 && inverse > 0 || num > 0 && inverse < 0)
                return 0;

            if (Integer.MAX_VALUE / 10 < inverse || Integer.MIN_VALUE / 10 > inverse)
                return 0;

            inverse = inverse * 10;
            int value = num % 10;
            inverse += value;

            num = num / 10;
        }

        return inverse;
    }
}
