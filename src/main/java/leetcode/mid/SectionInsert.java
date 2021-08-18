package leetcode.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：hcy
 * @date ：Created in 2021/8/16
 * @description ：{{1,2},{3,5},{6,7},{8,10},{12,16}};
 * @version: 1.0
 */
public class SectionInsert {
    public static void main(String[] args) {
        int[][] intervals = {{1,5}};
        int[] newInterval = {6, 8};
        int[][] insert = insert(intervals, newInterval);
        System.out.println(insert);

    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            int[][] ints = new int[1][2];
            ints[0][0]=newInterval[0];
            ints[0][1]=newInterval[1];

            return ints;
        }
        List<int[]> merged = new ArrayList<int[]>();
        int insert = 0;
        for (int i = 0; i < intervals.length; i++) {
            int L = intervals[i][0], R = intervals[i][1];
            if (newInterval[0] < L) {
                insert = i;
                break;
            }
            if (i == intervals.length - 1) {
                insert = i + 1;
            }
        }
        boolean flag = false;
        for (int i = 0; i <= intervals.length; i++) {
            if (i == insert && !flag) {
                int L = newInterval[0], R = newInterval[1];
                if (merged.size() == 0||merged.get(merged.size() - 1)[1] < L) {
                    merged.add(new int[]{L, R});
                } else {
                    merged.get(merged.size() - 1)[1] = Math.max(R, merged.get(merged.size() - 1)[1]);
                }
                flag = true;
            } else if (i > insert && flag) {
                int L = intervals[i - 1][0], R = intervals[i - 1][1];
                if (L > merged.get(merged.size() - 1)[1]) {
                    merged.add(new int[]{L, R});

                } else {
                    merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
                }
            } else if (i < insert) {
                int L = intervals[i][0], R = intervals[i][1];
                merged.add(new int[]{L, R});
            }
        }
        return merged.toArray(new int[merged.size()][]);

    }
}
