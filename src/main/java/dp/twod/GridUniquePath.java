package dp.twod;

import java.util.Arrays;

class GridUniquePath {
  public int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];
    for (int i = 0; i < dp.length; i++) {
      Arrays.fill(dp[i], -1);
    }
    return uniquePaths(m - 1, n - 1, dp);
  }

  private int uniquePaths(int row, int col, int[][] dp) {
    if (row == 0 && col == 0) return 1;
    if (row < 0 || col < 0) return 0;
    if (dp[row][col] != -1) return dp[row][col];
    int left = uniquePaths(row - 1, col, dp);
    int right = uniquePaths(row, col-1, dp);
    return dp[row][col] = (left + right);
  }
}
