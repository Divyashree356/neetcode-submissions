class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        getSub(ans, new ArrayList<>(), nums, 0);
        return ans;
    }
    
    public void getSub(List<List<Integer>> ans, List<Integer> cur, int[]nums, int start){
        ans.add(new ArrayList<>(cur));

        for(int i = start; i < nums.length; i++){
            if(start < i && nums[i] == nums[i-1]) continue;
            cur.add(nums[i]);
            getSub(ans, cur, nums, i+1 );
            cur.remove(cur.size() -1);
        }
        
    }

}