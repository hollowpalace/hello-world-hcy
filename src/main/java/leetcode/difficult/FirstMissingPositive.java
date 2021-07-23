package leetcode.difficult;

import java.util.HashSet;

/**
 * @author ：hcy
 * @date ：Created in 2021/7/21
 * @description ：
 * @version: 1.0
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {0};
        System.out.println(firstMissingPositive(nums));

    }

    public static int firstMissingPositive(int[] nums) {
        int positive = -1;
        int max = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && positive == -1) {
                positive = i;
            }
            if (nums[i] > 0 && nums[i] < nums[positive]) {
                positive = i;
            }
            if (nums[i] > nums[max]) {
                max = i;
            }
            set.add(nums[i]);
        }
        if (positive==-1){
            return 1;
        }
        if (nums[positive] == 1) {
            for (int i = nums[positive]; i <= nums[max]; i++) {
                if (set.contains(i)) {
                    continue;
                }
                return i;
            }

        } else if (nums[positive] > 1) {
            return 1;
        }
        return nums[max] + 1;
    }
}
