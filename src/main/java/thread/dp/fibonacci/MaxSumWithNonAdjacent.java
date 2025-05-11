package thread.dp.fibonacci;

class MaxSumWithNonAdjacent {
  public int nonAdjacent(int[] nums) {
    int length = nums.length;
    return nonAdjacent(nums, length - 1);
  }

  private int nonAdjacent(int[] nums, int index) {
    if (index == 0) return nums[index];
    if (index < 0) return 0;
    int left = nonAdjacent(nums, index - 2) + nums[index];
    int right = nonAdjacent(nums, index - 1) + 0;
    return Math.max(left, right);
  }
}
