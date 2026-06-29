class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for(int i : nums) totalSum += i;

        if(totalSum - target  < 0 || (totalSum - target)%2 != 0) return 0;
        int newTarget = Math.abs(totalSum - target)/2;

        int[][] dp = new int[nums.length+1][newTarget+1];
        for(int[] d : dp)Arrays.fill(d, -1);
        return getCount(nums, newTarget, nums.length-1, dp);
    }

    public int getCount(int[] nums, int target, int idx, int[][] dp){
        
        if(idx == 0) {
            if(target == 0 && nums[idx] == 0) return 2;
            if(target == 0 || target == nums[idx]) return 1;
            return 0;
        }
        
        if(dp[idx][target] != -1) return dp[idx][target];
        
        int notPick = getCount(nums, target, idx-1, dp);
        
        int pick=0;
        if(nums[idx]<= target) pick = getCount(nums, target - nums[idx], idx-1, dp);
        return dp[idx][target]=pick + notPick;
    }
}