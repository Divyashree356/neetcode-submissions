class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return rec(dp, nums, n-1);
    }

    public int rec(int[] dp, int[] nums, int idx){
        if(idx == 0) return nums[idx];
        if(idx < 0) return 0;
        if(dp[idx] != -1) return dp[idx];

        int pick = nums[idx] + rec(dp, nums, idx-2);
        int notPick = rec(dp, nums,  idx-1);

        return dp[idx]=Math.max(pick, notPick);
    }
}
