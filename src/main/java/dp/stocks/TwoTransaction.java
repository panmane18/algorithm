package dp.stocks;

import java.util.Arrays;

class TwoTransaction {
    public int stockBuySell(int[] arr, int n) {
        if (n == 0) return 0;
        int[][][] dp = new int[n][2][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        int ans = maxProfit(arr, 0, 0, dp, 2);
        return ans;
    }

    public int maxProfit(int[] arr, int index, int buy, int[][][] dp, int transaction) {
        if (transaction == 0) return 0;
        if (arr.length == index) return 0;
        if (dp[index][buy][transaction] != -1) return dp[index][buy][transaction];
        int profit = 0;
        if (buy == 0) {
            int take = maxProfit(arr, index + 1, 1, dp, transaction) - arr[index];
            int notTake = 0 + maxProfit(arr, index + 1, 0, dp, transaction);
            profit = Math.max(take, notTake);
        } else {
            int take = maxProfit(arr, index + 1, 0, dp, transaction - 1) + arr[index];
            int notTake = 0 + maxProfit(arr, index + 1, 1, dp, transaction);
            profit = Math.max(take, notTake);
        }
        return dp[index][buy][transaction] = profit;
    }
}
