class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp, -1);
        return (s.length() == 0 ? 0 : numDec(s, 0, dp));
    }

    public int numDec(String s, int idx, int[] dp) {
        if (s.length() == idx)
            return 1;
        if (s.charAt(idx) == '0')
            return 0;
        if(dp[idx] != -1) return dp[idx];

        dp[idx] = numDec(s, idx + 1, dp);
        if (idx < s.length() - 1 && (s.charAt(idx) == '1' || s.charAt(idx) == '2' && s.charAt(idx + 1) < '7'))
            dp[idx] += numDec(s, idx + 2, dp);
        return dp[idx];
    }
}