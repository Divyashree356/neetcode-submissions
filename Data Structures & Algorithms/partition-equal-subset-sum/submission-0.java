class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums) sum += n;

        int n = nums.length;
        if(sum % 2 == 0){
            Arrays.sort(nums);
            int target = sum/2;
            Boolean[][] dp = new Boolean[n+1][target+1];
            return getParts(nums, target, n-1, dp);
        } 
        else return false;
    }

    public boolean getParts(int[] nums, int target, int idx, Boolean[][] dp ){
        if(target == 0) return true;
        if(idx == 0) return nums[0] == target ? true : false;
        
    
        if(dp[idx][target] != null) return dp[idx][target];

        boolean notTake = getParts(nums, target, idx-1, dp);
        boolean  take = false;

        if(nums[idx] <= target){
            take = getParts(nums, target- nums[idx], idx-1, dp);
        }
        
        return dp[idx][target] = (notTake || take);
    }
}