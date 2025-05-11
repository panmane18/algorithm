package thread.dp.fibonacci;

import java.util.Arrays;

class HouseRobber {
    public int houseRobber(int[] money) {
        int n = money.length;

        int[] dp1 = new int[n - 1];
        Arrays.fill(dp1, -1);

        int[] dp2 = new int[n - 1];
        Arrays.fill(dp2, -1);

        int[] arr1 = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            arr1[i] = money[i];
        }

        int[] arr2 = new int[n - 1];
        for (int i = 1; i < n; i++) {
            arr2[i - 1] = money[i];
        }

        int ans1 = houseRobber(arr1, arr1.length - 1, dp1);
        int ans2 = houseRobber(arr2, arr2.length - 1, dp2);

        return Math.max(ans1, ans2);

    }

    private int houseRobber(int[] money, int index, int[] dp) {
        if (index == 0) return money[index];
        if (index < 0) return 0;
        if (dp[index] != -1) return dp[index];
        int left = houseRobber(money, index - 2, dp) + money[index];
        int right = houseRobber(money, index - 1, dp) + 0;
        return dp[index] = Math.max(left, right);
    }
}

