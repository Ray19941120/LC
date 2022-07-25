package lc_greedy;

/**
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 */
public class LC_121_SaleStock {
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(arr));
    }

    public static int maxProfit(int[] prices) {
        //记录前面的最小价格，将这个最小价格作为买入价格，然后将当前的价格作为售出价格，查看当前的收益是不是最大的
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int soFarmin = prices[0];
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (soFarmin > prices[i]) {
                soFarmin = prices[i];
            }else {
                max = Math.max(max, prices[i] - soFarmin);
            }
        }
        return max;
    }
}
