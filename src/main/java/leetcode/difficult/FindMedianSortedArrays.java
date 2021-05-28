package leetcode.difficult;

/**
 * @author ：hcy
 * @date ：Created in 2021/5/26
 * @description ：
 * @version: 1.0
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int nums1[] = {1,2};
        int nums2[] = {-1,3};


    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = m;
        // median1：前一部分的最大值
        // median2：后一部分的最小值
        int median1 = 0, median2 = 0;

        while (left <= right) {
            // 前一部分包含 nums1[0 .. i-1] 和 nums2[0 .. j-1]
            // 后一部分包含 nums1[i .. m-1] 和 nums2[j .. n-1]
            int i = (left + right) / 2;
            int j = (m + n + 1) / 2 - i;

            // nums_im1, nums_i, nums_jm1, nums_j 分别表示 nums1[i-1], nums1[i], nums2[j-1], nums2[j]
            int nums_im1 = (i == 0 ? Integer.MIN_VALUE : nums1[i - 1]);
            int nums_i = (i == m ? Integer.MAX_VALUE : nums1[i]);
            int nums_jm1 = (j == 0 ? Integer.MIN_VALUE : nums2[j - 1]);
            int nums_j = (j == n ? Integer.MAX_VALUE : nums2[j]);

            if (nums_im1 <= nums_j) {
                median1 = Math.max(nums_im1, nums_jm1);
                median2 = Math.min(nums_i, nums_j);
                left = i + 1;
            } else {
                right = i - 1;
            }
        }

        return (m + n) % 2 == 0 ? (median1 + median2) / 2.0 : median1;
    }










    public double findMedianSortedArraysmy(int[] nums1, int[] nums2) {
        int[] ints = new int[nums1.length + nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            ints[i] = nums1[i];
        }
        for (int i = nums1.length; i < nums1.length + nums2.length; i++) {
            ints[i] = nums2[i - nums1.length];
        }
        int k = 0;
        for (int i = 0; i < ints.length - 1; i++) {
            for (int j = i + 1; j < ints.length; j++) {
                if (ints[i] > ints[j]) {
                    k = ints[i];
                    ints[i] = ints[j];
                    ints[j] = k;
                }
            }
        }
        int length = ints.length;
        if (length % 2 == 0) {
            double re = (double) (ints[length / 2] + ints[length / 2 - 1]) / 2;
            return re;
        } else {
            return (double) ints[length / 2];
        }

    }
}
