package dp.twod;

import java.util.Arrays;

class Triangle {
  public int minTriangleSum(int[][] triangle) {
    int n = triangle.length;
    int[][] dp = new int[n][n];
    for (int[] row : dp) {
      Arrays.fill(row, -1);
    }
    return minTriangleSum(0, 0, triangle, dp);
  }

  private int minTriangleSum(int row, int col, int[][] triangle,int[][] dp) {
    if (row >= triangle.length) return (int) 1e9;
    if (row == triangle.length - 1) return triangle[row][col];
    if (dp[row][col] != -1) return dp[row][col];
    int bottom = triangle[row][col] + minTriangleSum(row + 1, col, triangle, dp);
    int right = triangle[row][col] + minTriangleSum(row + 1, col + 1, triangle, dp);
    return dp[row][col] = Math.min(right, bottom);
  }
}
