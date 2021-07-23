package leetcode.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author ：hcy
 * @date ：Created in 2021/7/20
 * @description ：
 * @version: 1.0
 */
public class CombinationSum3 {
    static int count=0;
    public static void main(String[] args) {
//        combinationSum3(3, 7);
        int[] nums = {1,2,3};
        int target =4;
        int i = combinationSum4(nums, 4);
        System.out.println(i);
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();
        dfs(combine, ans, k, n, 1);
        return ans;
    }

    public static void dfs(List<Integer> combine, List<List<Integer>> ans, int k, int n, int index) {
        if (k == 0) {
            if (n == 0) {
                ans.add(new ArrayList<Integer>(combine));
                return;
            }
        }

        for (int i = index; i < 10; i++) {
            if (i <= n) {
                combine.add(i);
                dfs(combine, ans, k - 1, n - i, i + 1);
                combine.remove(combine.size() - 1);
            }
        }

    }

    public static int combinationSum4(int[] nums, int target) {


        List<Integer> com = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs2(com, nums, target);
        return com.size();
    }

    public static void dfs2(List<Integer> com, int[] nums, int target) {
        if (target == 0) {
            com.add(1);
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= target) {
                dfs2(com, nums, target - nums[i]);
            }
        }

    }

}
