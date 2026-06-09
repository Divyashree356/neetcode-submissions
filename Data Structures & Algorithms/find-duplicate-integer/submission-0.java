class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+1];
        Arrays.fill(arr, 0);

        for(int i =0; i < n; i++){
            if(arr[nums[i]] == 1) return nums[i];
            arr[nums[i]]++;
        }        
        return -1;
    }
}