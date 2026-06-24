class Solution {
    public int rob(int[] nums) {

        int n = nums.length;
        if(n < 2){
            return nums[0];
        }
        if(n==0) return 0;


        int[] takF = new int[n+1];
        int[] takS = new int[n+1];
        Arrays.fill(takF, 0);
        Arrays.fill(takS, 0);

        takF[1] = nums[0];
        takS[1] = 0;

        for(int i = 1; i < n; i++){
            takF[i+1] = Math.max(nums[i] + takF[i-1], takF[i]);
            takS[i+1] = Math.max(nums[i] + takS[i-1], takS[i]);
        }
        return Math.max(takF[n-1], takS[n]);

    }
}
