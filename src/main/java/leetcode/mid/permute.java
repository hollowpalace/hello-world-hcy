package leetcode.mid;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：hcy
 * @date ：Created in 2021/7/29
 * @description ：
 * @version: 1.0
 */
public class permute {
    public static void main(String[] args) {
        int[] nums ={1,2,3};
        List<List<Integer>> permute = permute(nums);
        System.out.println(permute);

    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(nums[i]);
            method(result, list, nums);
        }
        return result;
    }

    public static void method(List<List<Integer>> result, ArrayList<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            result.add(list);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            ArrayList<Integer> listNext = new ArrayList<>(list);
            listNext.add(nums[i]);
            method(result, listNext, nums);
        }
    }

}
