class Solution {

    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for(int[] d : dp) Arrays.fill(d, -1);
        return countSub(s, t, 0, 0, dp);
    }
    public int countSub(String s, String t, int i, int j, int[][] dp){
        if(j == t.length()) return 1;
        if(i == s.length()) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        int ans = countSub(s, t, i+1, j, dp);
        if(s.charAt(i) == t.charAt(j)){
            ans += countSub(s, t, i+1, j+1, dp);
        }
        return dp[i][j] = ans;
    }
}