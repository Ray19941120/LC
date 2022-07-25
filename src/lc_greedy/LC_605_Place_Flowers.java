package lc_greedy;

/**
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: True
 */
public class LC_605_Place_Flowers {

    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 0, 1};
        System.out.println(canPlaceFlowers(arr,2));
    }

    /**
     *如果当前的位置的左右两边都是0，那么可以种植
     * 注意下边界就行
     */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }
            int pre = i == 0 ? 0 : flowerbed[i - 1];
            int post = i == 0 ? 0 : flowerbed[i + 1];
            if (pre == 0 && post == 0) {
                cnt++;
            }
        }
        return cnt>=n;
    }
}
