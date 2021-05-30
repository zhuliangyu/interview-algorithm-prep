// https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/

class Solution {
    // 买卖股票的次数无限制
    // 只要判断前后两天有没有利润, 有利润就操作, 就是最大化profit

    // 贪心法
    public int maxProfit(int[] prices) {
        int profits = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] - prices[i] >= 0) {
                profits += prices[i + 1] - prices[i];
            }
        }


        // 贪心算法只能用于计算最大利润，计算的过程并不是实际的交易过程
        // [1,2,3,4,5]
        // 实际的交易过程并不是进行 4次买入和 4次卖出，而是在第 1 天买入，第 5 天卖出
        return profits;

    }
}
