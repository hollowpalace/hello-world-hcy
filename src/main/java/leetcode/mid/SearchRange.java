package leetcode.mid;

import java.util.Arrays;

/**
 * @author ：hcy
 * @date ：Created in 2021/7/12
 * @description ：[5,7,7,8,8,10]
 * @version: 1.0
 */
public class SearchRange {
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int target = 1;
        int[] ints = searchRange(nums, target);
        System.out.println(Arrays.toString(ints));


    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        int l = 0;
        int r = nums.length - 1;


        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                l = mid - 1;
                r = mid + 1;
                while (l >= 0 && nums[l] == target) {
                    l--;
                }
                while (r <= nums.length - 1 && nums[r] == target) {
                    r++;
                }
                result[0] = l + 1;
                result[1] = r - 1;
                return result;
            }
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            }
        }

        return result;

    }
}
