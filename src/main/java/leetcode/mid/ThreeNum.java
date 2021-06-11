package leetcode.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：hcy
 * @date ：Created in 2021/6/10
 * @description ：
 * @version: 1.0
 */
public class ThreeNum {
    public static void main(String[] args) {


    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;

                } else if (sum > 0) {
                    r--;
                } else if (sum < 0) {
                    l++;
                }
            }
        }
        return result;
    }

    public int threeSumClosest(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int closeNum = Integer.MAX_VALUE;
        int closeNumSum = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum - target == 0) {
                    return sum;
                }
                if (Math.abs(sum - target) < closeNum) {
                    closeNum = Math.abs(sum - target);
                    closeNumSum = sum;
                }
                if (sum - target > 0) {
                    r--;
                } else if (sum - target < 0) {
                    l++;
                }
            }

        }
        return closeNumSum;


    }
}
