package leetcode.mid;

import com.sun.org.apache.regexp.internal.RE;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author ：hcy
 * @date ：Created in 2021/7/28
 * @description ：[10,9,8,7,6,5,4,3,2,1,1,0]
 * @version: 1.0
 */
public class Jump {
    public static void main(String[] args) {
        int[] nums2 = {5, 6, 4, 4, 6, 9, 4, 4, 7, 4, 4, 8, 2, 6, 8, 1, 5, 9, 6, 5, 2, 7, 9, 7, 9, 6, 9, 4, 1, 6, 8, 8, 4, 4, 2, 0, 3, 8, 5};
        int[] nums = {0};
        System.out.println(jump(nums));


    }

    private static ArrayList<Integer> stepList = new ArrayList<Integer>();

    public static int jump2(int[] nums) {
        method(nums, 0, 0);
        List<Integer> collect = stepList.stream().sorted().collect(Collectors.toList());
        return collect.get(0);

    }

    public static void method(int[] nums, int p, int step) {
        if (p >= nums.length - 1) {
            stepList.add(step);
            return;
        }
        if (nums[p] == 0) {
            return;
        }
        for (int i = p + 1; i <= p + nums[p]; i++) {
            if (i >= nums.length - 1) {
                stepList.add(step);
                return;
            }
            method(nums, i, step + 1);
        }
    }

    public static int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int step = 0;
        int position = 0;

        while (position < nums.length) {
            int len = nums[position];
            if (position+len>=nums.length-1){
                step++;
                return step;
            }
            int next = position + 1;
            for (int i = position + 1; i <= position + len; i++) {
                if (i + nums[i] >= nums.length - 1) {
                    step = step + 2;
                    return step;
                }
                if (nums[i] == 0) {
                    continue;
                }
                if (i + nums[i] >= next + nums[next]) {
                    next = i;
                }

            }
            step++;
            position = next;
        }
        return step;

    }

}
