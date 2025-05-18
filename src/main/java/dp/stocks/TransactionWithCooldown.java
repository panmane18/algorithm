package dp.stocks;

import java.util.Arrays;

class TransactionWithCooldown {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int[][] dp = new int[n][2];
        for (int[] ar : dp)
            Arrays.fill(ar, -1);
        int ans = maxProfit(prices, 0, 0, dp);
        return ans;
    }

    private int maxProfit(int[] prices, int index, int buy, int[][] dp) {
        if (index >= prices.length) {
            return 0;
        }
        if (dp[index][buy] != -1) return dp[index][buy];
        int profit = 0;
        if (buy == 0) {
            int take = maxProfit(prices, index + 1, 1, dp) - prices[index];
            int notTake = 0 + maxProfit(prices, index + 1, 0, dp);
            profit = Math.max(take, notTake);
        } else {
            int take = maxProfit(prices, index + 2, 0, dp) + prices[index];
            int notTake = 0 + maxProfit(prices, index + 1, 1, dp);
            profit = Math.max(take, notTake);
        }
        return dp[index][buy] = profit;
    }
}