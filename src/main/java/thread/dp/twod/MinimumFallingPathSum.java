package thread.dp.twod;

import java.util.Arrays;

class MinimumFallingPathSum {
  public int minFallingPathSum(int[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;
    int mini = Integer.MAX_VALUE;
    int[][] dp = new int[n][m];
    for (int j = 0; j < n; j++) {
      Arrays.fill(dp[j], -1);
    }
    for (int i = 0; i < m; i++) {
      int ans = minFallingPathSum(n - 1, i, matrix, dp);
      mini = Math.min(mini, ans);
    }
    return mini;
  }

  private int minFallingPathSum(int row, int col, int[][] matrix, int[][] dp) {
    if (row < 0 || col < 0 || col > matrix[0].length - 1) return (int) 1e9;
    if (row == 0) return matrix[row][col];
    if (dp[row][col] != -1) return dp[row][col];
    int mini = Integer.MAX_VALUE;
    for (int i = -1; i <= 1; i++) {
      int ans = matrix[row][col] + minFallingPathSum(row - 1, col + i, matrix, dp);
      mini = Math.min(mini, ans);
    }
    return dp[row][col] = mini;
  }
}
