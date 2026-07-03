class Solution {
    public int jump(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return canJ(nums, 0, dp); 
        
    }
     public int canJ(int[] nums, int curIdx, int[] dp){

        if(curIdx >= nums.length-1) return 0;
        if(dp[curIdx] != -1) return dp[curIdx];

        int ans = Integer.MAX_VALUE;
        for(int i = nums[curIdx]; i > 0; i--){
            if(i + curIdx < nums.length){
                int next = canJ(nums, i+curIdx, dp);
                if(next != Integer.MAX_VALUE){
                    ans = Math.min(ans, 1+next);
                }
            }
        }
        return dp[curIdx] = ans;
    
    }
}
