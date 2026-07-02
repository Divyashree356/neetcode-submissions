class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int maxS = nums[0];

        for(int i=1; i < nums.length; i++){
            sum += nums[i];
            if(sum < nums[i]) sum = nums[i];

            maxS= Math.max(sum, maxS);
        }

        return maxS;
    }
}