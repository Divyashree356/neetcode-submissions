class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()];
        return ans(s, 0, wordDict, dp);       
    }

    public boolean ans(String s, int start, List<String> wordDict, Boolean[] dp){
        if(start == s.length()) return true;
        if(dp[start] != null) return dp[start];
        for(int end = start+1; end <= s.length(); end++){
            if(wordDict.contains(s.substring(start, end)) && ans(s, end, wordDict, dp)){
                return dp[start] = true;
            }
        }
        return dp[start] = false;
    }
}