package dp.stocks;

import java.util.Arrays;

class TransactionWithFees {
    public int stockBuySell(int[] arr, int n, int fee) {
        if (n == 0) return 0;
        int[][] dp = new int[n][2];
        for (int[] ar : dp) Arrays.fill(ar, -1);
        int ans = maxProfit(arr, 0, 0, dp, fee);
        return ans;
    }

    public int maxProfit(int[] arr, int index, int buy, int[][] dp, int fee) {
        if (arr.length == index) {
            return 0;
        }
        if (dp[index][buy] != -1) return dp[index][buy];
        int profit = 0;
        if (buy == 0) {
            int take = maxProfit(arr, index + 1, 1, dp, fee) - arr[index];
            int notTake = 0 + maxProfit(arr, index + 1, 0, dp, fee);
            profit = Math.max(take, notTake);
        } else {
            int take = maxProfit(arr, index + 1, 0, dp, fee) + arr[index] - fee;
            int notTake = 0 + maxProfit(arr, index + 1, 1, dp, fee);
            profit = Math.max(take, notTake);
        }
        return dp[index][buy] = profit;
    }
}
