package leetcode.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：hcy
 * @date ：Created in 2021/7/30
 * @description ：
 * @version: 1.0
 */
public class PermuteUnique {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permuteUnique = permuteUnique(nums);
        System.out.println(permuteUnique);

    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            ArrayList<Integer> iList = new ArrayList<Integer>();
            iList.add(i);
            method(result, nums, iList);
        }
        return result;

    }

    public static void method(List<List<Integer>> result, int[] nums, List<Integer> iList) {
        if (iList.size() == nums.length) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < iList.size(); i++) {
                list.add(nums[iList.get(i)]);
            }
            result.add(list);
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (iList.contains(i)) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !iList.contains(i - 1)) {
                continue;
            }
            ArrayList<Integer> listNext = new ArrayList<>(iList);
            listNext.add(i);
            method(result, nums, listNext);
        }


    }
}
