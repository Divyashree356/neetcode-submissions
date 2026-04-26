class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
     List<List<Integer>> ans = new ArrayList<>();
     Arrays.sort(nums);

     for(int i=0; i < nums.length; i++){

        if(i > 0 && nums[i] == nums[i-1]) continue;
        // System.out.println("here");
        int low = i+1;
        int high = nums.length -1;

        while(low < high){
            int sum =nums[low] + nums[high] + nums[i];

            if (sum == 0){
             
             List<Integer> sub = new ArrayList<>();
             sub.add(nums[i]);
             sub.add(nums[low]);
             sub.add(nums[high]);
             ans.add(sub);

             while(low < high && nums[low] == nums[low+1]) low++;
             while(low < high && nums[high] == nums[high-1]) high--;

             low++;
             high--;


            }    
            else if (sum > 0) high--;
            else low++;
        }

     }   
     return ans;
    }
}