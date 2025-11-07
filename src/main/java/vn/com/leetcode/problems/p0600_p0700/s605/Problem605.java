package vn.com.leetcode.problems.p0600_p0700.s605;

/**
 * @author: tu.phianh
 * @mail: tu.phianh@ivnd.com.vn
 * @created: 07/11/2025
 */
public class Problem605 {

    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 1}, 2));
        System.out.println(canPlaceFlowers(new int[]{1, 0, 1, 0, 1, 0, 1}, 1));
    }

    private static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] != 0) continue;

            boolean emptyLeftPlot = (i == 0) || (flowerbed[i - 1] == 0);
            boolean emptyRightPlot = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0);

            if (emptyLeftPlot && emptyRightPlot) {
                flowerbed[i] = 1;
                count++;
            }
        }

        return count >= n;
    }

}
