package leetcode.low;

/**
 * @author ：hcy
 * @date ：Created in 2021/8/6
 * @description ：
 * @version: 1.0
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {2, 1, -3, 4, -1, 2, 1, -5, 4};
        int i = maxSubArray(nums);
        System.out.println(i);


    }

    public static int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }



    public static int sumPlus(int[] nums, int l, int r) {
        int sum = 0;
        for (int i = l; i <= r; i++) {
            sum = sum + nums[i];
        }
        return sum;
    }
}
