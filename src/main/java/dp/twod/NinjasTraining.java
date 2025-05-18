package dp.twod;

class NinjasTraining {
  public int ninjaTraining(int[][] matrix) {
    return ninjaTraining(0, -1, matrix);
  }

  private int ninjaTraining(int index, int prev, int[][] matrix) {
    if (index == matrix.length - 1) {
      int maximun = 0;
      for (int i = 0; i < matrix[0].length; i++) {
        if (i != prev) {
          maximun = Math.max(maximun, matrix[index][i]);
        }
      }
      return maximun;
    }
    int maxi = 0;
    for (int i = 0; i < matrix[0].length; i++) {
      if (i != prev) {
        int ans = matrix[index][i] + ninjaTraining(index + 1, i, matrix);
        maxi = Math.max(ans, maxi);
      }
    }
    return maxi;
  }
}
