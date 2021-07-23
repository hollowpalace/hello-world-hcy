package leetcode.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author ：hcy
 * @date ：Created in 2021/7/19
 * @description ：
 * @version: 1.0
 */
public class NumSumUnlimited {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        combinationSum(candidates, 7);
        List<String> strings = Arrays.asList("Hollis", "HollisChuang", "hollis", "Hello", "HelloWorld", "Hollis");
        Stream<String> stream = strings.stream();


    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    public static void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<Integer>(combine));
            return;
        }

        dfs(candidates, target, ans, combine, idx + 1);

        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], ans, combine, idx);
            combine.remove(combine.size() - 1);
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();
        Arrays.sort(candidates);
        dfs2(candidates, target, ans, combine, 0);
        return ans;

    }

    public static void dfs2(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {

        if (target == 0) {
            ans.add(new ArrayList<Integer>(combine));
        }

        for (int i = idx; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                if (i > 0 && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                combine.add(candidates[i]);
                dfs(candidates, target - candidates[i], ans, combine, idx + 1);
                combine.remove(combine.size() - 1);
            }

        }
    }

}
