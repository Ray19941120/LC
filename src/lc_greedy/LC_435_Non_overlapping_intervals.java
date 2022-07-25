package lc_greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Input: [ [1,2], [1,2], [1,2] ]
 *
 * Output: 2
 *
 * Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
 * [[1,2],[2,3],[3,4],[1,3]]
 * remove[1,3]
 */
public class LC_435_Non_overlapping_intervals {

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        //按照右边界从小到大的排序,比较的话是用左边界去碰最小的右边界
        Arrays.sort(intervals, Comparator.comparingInt(value -> value[1]));
        int count = 0;
        //为了不改变原数组，需要一个变量记录一下边界
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            //待比较的数如果小于最小的右边界的话，说明重叠了
            if (intervals[i][0] < end) {
                count++;
                continue;
            }
            end = intervals[i][1];
        }
        return count;
    }
}
