package dp.twod;

class Solution {
    public int stockBuySell(int[] arr, int n) {
        if (n == 0) return 0;
        int ans = maxProfit(arr, 0, 0);
        return ans;
    }

    public int maxProfit(int[] arr, int index, int buy) {
        if (arr.length == index) {
            return 0;
        }
        int profit = 0;
        if (buy == 0) {
            profit = Math.max(0 + maxProfit(arr, index + 1, 0), (-1) * arr[index] + maxProfit(arr, index + 1, 1));
        } else {
            profit = Math.max(0 + maxProfit(arr, index + 1, 1), arr[index] + maxProfit(arr, index + 1,0));
        }
        return profit;
    }
}
