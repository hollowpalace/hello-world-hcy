package leetcode.mid;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author ：hcy
 * @date ：Created in 2021/7/7
 * @description ：
 * @version: 1.0
 */
public class NextPermutation {
    public static void main(String[] args) {
        

        int[] a = {5, 4, 7, 5, 3, 2};
        nextPermutation(a);
        System.out.println(Arrays.toString(a));

    }

    public static void nextPermutation(int[] nums) {

        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                for (int k = i; k < nums.length - 1; k++) {
                    for (int l = i; l < nums.length - 1-(k-i) ; l++) {
                        if (nums[l + 1] < nums[l]) {
                            int t = nums[l + 1];
                            nums[l + 1] = nums[l];
                            nums[l] = t;
                        }

                    }
                }
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] > nums[i - 1]) {
                        int temp = nums[j];
                        nums[j] = nums[i - 1];
                        nums[i - 1] = temp;
                        break;
                    }
                }
                break;
            }
            if (i == 1 && nums[1] <= nums[0]) {
                Arrays.sort(nums);
            }
        }

    }
}
