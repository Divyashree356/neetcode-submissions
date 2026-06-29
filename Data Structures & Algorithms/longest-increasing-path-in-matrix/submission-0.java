class Solution {
    int[][] dir = {{0, 1}, {1,0}, {-1, 0}, {0, -1}};
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];
        for (int[] d : dp)
            Arrays.fill(d, -1);

        int max = Integer.MIN_VALUE;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                    max = Math.max(max, getPath(r, c, matrix, dp));
            }
        }
        return max;
    }

    public int getPath(int r, int c, int[][] matrix, int[][] dp) {

        if(dp[r][c] != -1) return dp[r][c];

        int best = 1;
        for(int[] d : dir){
            int nr = r + d[0];
            int nc = c + d[1];

            if(nr >= 0 && nc >= 0 && nr < matrix.length && nc < matrix[0].length && matrix[r][c] < matrix[nr][nc]){
                best = Math.max(best, 1+ getPath(nr, nc, matrix, dp));
            }
        }
        dp[r][c] = best;
        return best;

    }
}