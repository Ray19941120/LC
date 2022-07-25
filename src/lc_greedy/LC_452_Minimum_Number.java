package lc_greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Input:
 * [[10,16], [2,8], [1,6], [7,12]]
 *
 * Output:
 * 2
 */
public class LC_452_Minimum_Number {

    public static void main(String[] args) {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println(findMinArrowShots(points));
    }
    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(value -> value[1]));
        int end = points[0][1];
        int count = 0;
        for (int i = 1; i < points.length; i++) {
            //比最小的边界小，说明重叠了，这里扎气球考虑相等的情况
            if (points[i][0] <= end) {
                count++;
                continue;
            }
            end = points[i][1];
        }
        return count;
    }
}
