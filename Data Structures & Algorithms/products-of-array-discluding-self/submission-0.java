class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums.length <= 1)return nums;
        
        int n = nums.length;
        int[] prefix = new int[n];

        int p = 1;
        for(int i =0; i <n; i++){
            p *= nums[i];
            prefix[i] = p;
        }
        p=1;

        for(int i=n-1; i>0; i--){
            
            prefix[i] = prefix[i-1]*p;
            p *= nums[i];

        }   

        prefix[0] = p;
        return prefix;


    }
}  
