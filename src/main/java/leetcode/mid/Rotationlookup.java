package leetcode.mid;

/**
 * @author ：hcy
 * @date ：Created in 2021/7/9
 * @description ：
 * @version: 1.0
 */
public class Rotationlookup {
    public static void main(String[] args) {

        int[] nums = {11,12,13,14,15,16,17,18,19,20,21,22,23,24,1,2,3,4,5,6,7,8,9,10};

        int i = search2(nums, 23);
        System.out.println(i);

    }

    public static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int rotation = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                rotation = i + 1;
            }
        }

        for (int i = rotation; i < nums.length ; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        for (int i = 0; i < rotation; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;

    }
    public static int search2(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }


}
