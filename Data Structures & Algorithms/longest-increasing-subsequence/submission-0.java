class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int[] d : dp) Arrays.fill(d, -1);
        return getAns(nums, 0, -1, dp);   
    }
    public int getAns(int[] nums, int idx, int prev, int[][] dp){
        if(idx == nums.length) return 0;
        
        if(dp[idx][prev+1] != -1) return dp[idx][prev+1];
        
        int take = Integer.MIN_VALUE;
        if(prev != -1 && nums[idx] > nums[prev]){
            take = 1 + getAns(nums, idx+1, idx, dp);
        }
        if(prev == -1) {
            take = 1 + getAns(nums, idx+1, idx, dp);
        }
        int notTake= getAns(nums, idx+1, prev, dp);
    
        return dp[idx][prev+1]=Math.max(take, notTake);
    }
}