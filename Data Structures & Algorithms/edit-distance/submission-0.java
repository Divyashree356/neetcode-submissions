class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] d : dp) Arrays.fill(d, -1);
        return getD(word1, word2, n -1, m-1, dp);
    }

    public int getD(String word1, String word2, int s1, int s2, int[][] dp){

        if(s2 == -1) return s1+1;
        if(s1 == -1) return s2+1;

        if(dp[s1][s2] != -1) return dp[s1][s2];

        if(word1.charAt(s1) == word2.charAt(s2)) return dp[s1][s2] = getD(word1, word2, s1-1, s2-1, dp);
        
        int insert = 1 + getD(word1, word2, s1, s2-1, dp);
        int replace = 1 + getD(word1, word2, s1-1, s2-1, dp);
        int delete = 1 + getD(word1, word2, s1-1, s2, dp);

        return  dp[s1][s2] = Math.min(insert, Math.min(replace, delete));
    }
}