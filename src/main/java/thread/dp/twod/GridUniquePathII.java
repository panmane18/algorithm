package thread.dp.twod;

import java.util.Arrays;

class GridUniquePathII {
  public int uniquePathsWithObstacles(int[][] matrix) {
    int row = matrix.length;
    int col = matrix[0].length;
    int[][] dp = new int[row][col];
    for (int i = 0; i < row; i++) {
      Arrays.fill(dp[i], -1);
    }
    return uniquePathsWithObstacles(row - 1, col - 1, matrix, dp);
  }

  private int uniquePathsWithObstacles(int row, int col, int[][] matrix, int[][] dp) {
        if (row < 0 || col < 0 || matrix[row][col] == 1) return 0;
    if (row == 0 && col == 0) return 1;
    if (dp[row][col] != -1) return dp[row][col];
    int up = uniquePathsWithObstacles(row - 1, col, matrix, dp);
    int right = uniquePathsWithObstacles(row, col - 1, matrix, dp);
    return dp[row][col] = (up + right);
  }
}
