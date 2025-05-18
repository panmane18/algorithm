package dp.stocks;

class OneTransaction {
    public int stockBuySell(int[] arr, int n) {
        int mini = arr[0];
        int profit = 0;
        for (int i = 1; i < arr.length; i++) {
            int curProfit = arr[i] - mini;
            profit = Math.max(curProfit, profit);
            mini = Math.min(arr[i], mini);
        }
        return profit;
    }
}
