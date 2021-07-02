package leetcode.low;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：hcy
 * @date ：Created in 2021/6/29
 * @description ：
 * @version: 1.0
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        System.out.println(removeElement(nums, 2));

    }

    public int removeDuplicates(int[] nums) {

        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }

        int r = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                continue;
            }
            nums[r] = nums[i];
            r++;
            if (i == nums.length - 1) {
                return r;
            }
        }
        return r;
    }

    public static int removeElement(int[] nums, int val) {
        int r = 0;
        int l = nums.length;
        for (int i = 0; i < l - r; i++) {
            if (nums[i] == val) {

                for (int j = i + 1; j < l - r; j++) {
                    nums[j - 1] = nums[j];
                }
                r++;
                i--;
            }
        }

        return l - r;

    }
}
