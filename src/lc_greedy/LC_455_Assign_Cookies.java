package lc_greedy;

import java.util.Arrays;

/**
 * Input: grid[1,3], size[1,2,4]
 * Output: 2
 */
public class LC_455_Assign_Cookies {
    public static void main(String[] args) {
        int[] grid = {1,3};
        int[] size = {1, 2, 4};
        int contentChildren = findContentChildren(grid, size);
        System.out.println(contentChildren);
    }
    public static int findContentChildren(int[] grid, int[] size) {
        if (grid == null || size == null) {
            return 0;
        }
        Arrays.sort(grid);
        Arrays.sort(size);
        int gi = 0;
        int si = 0;
        while (gi < grid.length && si < size.length) {
            if (grid[gi] <= size[si]) {
                gi++;
            }
            si++;
        }
        return gi;
    }
}
