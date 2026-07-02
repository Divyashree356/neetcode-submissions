class Solution {
    public boolean canJump(int[] nums) {
        Boolean[] dp= new Boolean[nums.length];
        if(nums.length <= 1) return true;
        return canJ(nums, 0, dp); 
    }
    
    public boolean canJ(int[] nums, int curIdx, Boolean[] dp){
        if(curIdx >= nums.length-1) return true;

        if(dp[curIdx] != null) return dp[curIdx];

        for(int i = nums[curIdx]; i > 0; i--){
            boolean canJump = canJ(nums, curIdx+i, dp);
            if(canJump) return dp[curIdx]=true;
        }
        
        canJ(nums, curIdx+1, dp);
        return dp[curIdx] = false;
    
    }
}