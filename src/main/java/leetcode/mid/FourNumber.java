package leetcode.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：hcy
 * @date ：Created in 2021/6/16
 * @description ：
 * @version: 1.0
 */
public class FourNumber {
    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 2, 2};
        int target = 8;
        List<List<Integer>> lists = fourSum(nums, target);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }

    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        if (nums.length < 4) {
            return lists;
        }
        int l = 0;
        int r = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                l = j + 1;
                r = nums.length - 1;
                while (l < r) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        lists.add(list);
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        l++;
                        r--;
                    } else if (sum > target) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }
        return lists;
    }
}
