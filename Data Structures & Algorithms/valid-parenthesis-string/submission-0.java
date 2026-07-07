class Solution {
    public boolean checkValidString(String s) {
        Boolean[][] dp = new Boolean[s.length()+1][s.length()+1];
        return check(s, 0, 0, dp);   
    }

    public boolean check(String s, int idx, int count,  Boolean[][] dp){
        if(idx == s.length()) return (count == 0);
        if(count < 0) return false;
        if(dp[idx][count] != null) return dp[idx][count];



        if(s.charAt(idx) == '(') return  dp[idx][count]= check(s, idx+1, count+1, dp);
        if(s.charAt(idx) == ')') return  dp[idx][count]= check(s, idx+1, count-1, dp);
        if(s.charAt(idx) == '*') return  dp[idx][count]= check(s, idx+1, count+1, dp) || check(s, idx+1, count-1, dp) || check(s, idx+1, count, dp);

        return true;
    }
}