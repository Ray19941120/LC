package lc_greedy;

/**
 * 输入: prices = [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
   随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 *
 */
public class LC_122_SaleStock {

    /**
     * 对于 [a, b, c, d]，如果有 a <= b <= c <= d ，
     * 那么最大收益为 d - a。而 d - a = (d - c) + (c - b) + (b - a) ，
     * 因此当访问到一个 prices[i] 且 prices[i] - prices[i-1] > 0，
     * 那么就把 prices[i] - prices[i-1] 添加到收益中
     * 这个贪心就是只要后一天的收益比前一天高，就把收益加入到利润中
     */
    public static void main(String[] args) {
        int arr[] = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(arr));
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += (prices[i] - prices[i - 1]);
            }
        }
        return profit;
    }
}
