package thread.dp.fibonacci;

import java.util.Arrays;

class FrogJumps {
  public int frogJump(int[] heights) {
    int length = heights.length;
    int[] dp = new int[length];
    Arrays.fill(dp, -1);
    return frogJump(heights, length - 1, dp);
  }

  private int frogJump(int[] heights, int index, int[] dp) {
    if (index == 0) return 0;
    if (dp[index] != -1) return dp[index];
    int left = frogJump(heights, index - 1, dp) + Math.abs(heights[index] - heights[index - 1]);
    int right = Integer.MAX_VALUE;
    if (index > 1)
      right = frogJump(heights, index - 2, dp) + Math.abs(heights[index] - heights[index - 2]);
    return dp[index] = Math.min(left, right);
  }
}