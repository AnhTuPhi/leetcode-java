package vn.com.leetcode.problems.p1400_p1500.s1431;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: tu.phianh
 * @mail: tu.phianh@ivnd.com.vn
 * @created: 07/11/2025
 */
public class Problem1431 {

    public static void main(String[] args) {
        System.out.println(kidsWithCandies(new int[]{2,3,5,1,3}, 3));
        System.out.println(kidsWithCandies(new int[]{4,2,1,1,2}, 1));
        System.out.println(kidsWithCandies(new int[]{12,1,12}, 10));
        System.out.println(kidsWithCandies(new int[]{2,8,7}, 1));
    }

    private static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int limit = Arrays.stream(candies).max().orElseThrow();
        for (int i = 0; i < candies.length; i++) {
            candies[i] += extraCandies;
            if (candies[i] >= limit) {
                result.add(Boolean.TRUE);
            } else {
                result.add(Boolean.FALSE);
            }
        }
        return result;
    }

    public List<Boolean> kidsWithCandies2nd(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>();
        int maxCandies = 0;
        for(int num:candies) {
            maxCandies = Math.max(maxCandies,num);
        }

        for(int i = 0; i < candies.length; i++) {
            if(candies[i] + extraCandies >= maxCandies) {
                ans.add(i,true);
            }
            else ans.add(i,false);
        }

        return ans;
    }
}
