class Solution {
    public int longestConsecutive(int[] nums) {
        
        if (nums.length <= 1) return nums.length;
        
        Arrays.sort(nums);

        int newSize = 1;
        for(int i =1; i< nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[newSize++] = nums[i];
            }
        }

        int count = 1;
        int present = 1;

        System.out.println(Arrays.toString(nums));
        for(int i =1; i < newSize; i++){

            if(nums[i-1] == nums[i] -1){
                present++;
            }
            else{
                count = Math.max(present, count);
                present = 1;
            }
        }
    
    return Math.max(count, present);
    }
}
