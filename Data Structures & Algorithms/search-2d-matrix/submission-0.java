class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int r = 0; r < n; r++) {
            if (target == matrix[r][0] || target == matrix[r][m - 1])
                return true;
            if (target > matrix[r][0] && target < matrix[r][m - 1]) {
                int low = 0;
                int high = m - 1;

                while (low <= high) {
                    int mid = low + (high - low) / 2;
                    if (matrix[r][mid] == target)
                        return true;

                    if (matrix[r][mid] < target)
                        low++;
                    else
                        high--;
                }
            }
        }
        return false;
    }
}