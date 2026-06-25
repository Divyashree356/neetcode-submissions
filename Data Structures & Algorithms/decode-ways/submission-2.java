class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        int n = s.length();
        Arrays.fill(dp, 0);
        dp[n] = 1;
        for(int i = n-1;i >=0; i--){
            if(s.charAt(i) != '0'){
                dp[i] = dp[i+1];
                if(i < n-1 && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) < '7')))
                    dp[i] += dp[i+2];
            }
        }
        return dp[0];
    }
}