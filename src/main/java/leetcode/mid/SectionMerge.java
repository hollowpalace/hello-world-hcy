package leetcode.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author ：hcy
 * @date ：Created in 2021/8/13
 * @description ：
 * @version: 1.0
 */
public class SectionMerge {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 16}, {15, 18}};
        int[][] merge = merge(intervals);
        String string = Arrays.toString(merge);
        System.out.println(string);
        System.out.println(1);

    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }

        List<int[]> re = new ArrayList<>();
        int m = intervals.length;
        for (int i = 0; i < m; i++) {
            re.add(intervals[i]);
        }
        List<int[]> list = method(0, re);
        int[][] ints = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }

    public static List<int[]> method(int position, List<int[]> re) {
        if (position > re.size() - 2) {
            return re;
        }

        int[] first = re.get(position);
        int[] second = re.get(position + 1);
        int[] temp = new int[2];

//        if (first[0] > second[0]) {
//            temp = first;
//            first = second;
//            second = temp;
//        }
        if (first[1] >= second[0]) {
            int[] third = new int[2];
            third[0] = first[0];
            third[1] = Math.max(first[1], second[1]);
            re.add(position, third);
            re.remove(first);
            re.remove(second);
            re = method(position, re);
        } else {
            re = method(position + 1, re);

        }
        return re;
    }
}
