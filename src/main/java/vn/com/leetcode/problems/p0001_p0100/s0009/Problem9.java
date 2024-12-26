package vn.com.leetcode.problems.p0001_p0100.s0009;

/**
 * @author: tu.phianh
 * @mail: tu.phianh@ivnd.com.vn
 * @created: 26/12/2024
 */
public class Problem9 {

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    /**
     * check if a number is palindrome without convert to string
     * @param num
     * @return
     */
    private static boolean isPalindrome(int num) {
        if (num < 0) {
            return false;
        }

        int reverse = 0;
        int temp = num;

        while (temp != 0) {
            reverse = (reverse * 10) + (temp % 10);
            temp = temp / 10;
        }

        return num == reverse;
    }

}
