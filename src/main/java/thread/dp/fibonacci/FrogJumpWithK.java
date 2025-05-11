package thread.dp.fibonacci;

class FrogJumpWithK {
  public int frogJump(int[] heights, int k) {
    int lenght = heights.length;
    return frogJump(heights, k, lenght - 1);
  }

  private int frogJump(int[] heights, int k, int index) {
    if (index == 0) return 0;
    int min = Integer.MAX_VALUE;
    for (int i = 1; i <= k; i++) {
      if (index - i >= 0) {
        int res = frogJump(heights, k, index - i) + Math.abs(heights[index] - heights[index - i]);
        min = Math.min(min, res);
      }
    }
    return min;
  }
}
