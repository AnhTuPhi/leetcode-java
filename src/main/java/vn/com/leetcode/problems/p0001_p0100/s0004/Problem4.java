package vn.com.leetcode.problems.p0001_p0100.s0004;

import java.util.Arrays;

/**
 * @author : AnhTuPhi
 * @created : 12/24/2024 - 12:06 AM - Tuesday
 * @project : leetcode-java
 **/
public class Problem4 {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(bestFindMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(secondFindMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    }

    /**
     * 5ms
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        var merged = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, merged, 0, nums1.length);
        System.arraycopy(nums2, 0, merged, nums1.length, nums2.length);
        Arrays.sort(merged);

        if (merged.length % 2 == 1) {
            return merged[merged.length / 2];
        }

        return (merged[merged.length / 2 - 1] + merged[merged.length / 2]) / 2.0;
    }

    public static double bestFindMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0;
        int high = n1;

        while (low <= high) {

            int partition1 = (low + high) / 2;
            int partition2 = (n1 + n2 + 1) / 2 - partition1;

            int l1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int l2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];

            int r1 = (partition1 == n1) ? Integer.MAX_VALUE : nums1[partition1];
            int r2 = (partition2 == n2) ? Integer.MAX_VALUE : nums2[partition2];

            if ((l1 <= r2) && (l2 <= r1)) {

                if ((n1 + n2) % 2 == 0) {

                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {

                    return Math.max(l1, l2);
                }

            } else if (l1 > r2) {

                high = partition1 - 1;

            } else {

                low = partition1 + 1;
            }
        }

        return 0.0;
    }

    public static double secondFindMedianSortedArrays(int[] nums1, int[] nums2) {
        double[] merged = new double[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                merged[k] = nums1[i];
                i++;

            } else {
                merged[k] = nums2[j];
                j++;
            }
            k++;
        }
        while (i < nums1.length) {
            merged[k] = nums1[i];
            i++;
            k++;
        }
        while (j < nums2.length) {
            merged[k] = nums2[j];
            j++;
            k++;
        }

        if (merged.length % 2 == 0) {
            return (merged[merged.length / 2] + merged[merged.length / 2 - 1]) / 2;

        } else {
            return merged[merged.length / 2];

        }
    }
}
