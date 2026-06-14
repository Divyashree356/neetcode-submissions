class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length == 0) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        getSubset(ans, 0, nums, new ArrayList<>());
        return ans;
    }

    public void getSubset(List<List<Integer>> ans, int start, int[] nums, List<Integer> curr){
        
        ans.add(new ArrayList<>(curr));

        for(int i = start; i< nums.length; i++){
            curr.add(nums[i]);
            getSubset(ans, i+1, nums, curr);
            curr.remove(curr.size()-1);
        }
    }
}