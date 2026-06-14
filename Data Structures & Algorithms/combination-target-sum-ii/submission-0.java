class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        getCombSum(nums, target, ans, 0, 0, new ArrayList<>());
        return ans;
    }

    public void getCombSum(int[] nums, int target, List<List<Integer>> ans, int curSum, int start, List<Integer> cur) {
        
    if (curSum == target){
            ans.add(new ArrayList<>(cur));
            return;
    }
        
        if (curSum > target)
            return;

        for (int i = start; i < nums.length; i++) {

            //skipping dups
            if(i > start && nums[i] == nums[i-1]) continue;

            cur.add(nums[i]);
            getCombSum(nums, target, ans, curSum + nums[i], i+1, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
