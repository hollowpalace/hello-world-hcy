package leetcode.mid;

/**
 * @author ：hcy
 * @date ：Created in 2021/8/11
 * @description ：
 * @version: 1.0
 */
public class CanJump {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 1, 4, 1};
        boolean b = canJump(nums);
        System.out.println(b);

    }

    public static boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int step = 0;
        int position = 0;

        while (position < nums.length) {
            int len = nums[position];

            int next = position;
            for (int i = position; i <= position + len; i++) {
                if (i + nums[i] >= nums.length - 1) {
                    return true;

                }
                if (nums[i] == 0) {
                    continue;
                }
                if (i + nums[i] >= next + nums[next]) {
                    next = i;
                }

            }

            if (next == position) {
                return false;
            }
            step++;
            position = next;
        }
        return false;

    }
}
