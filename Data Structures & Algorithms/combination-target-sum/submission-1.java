class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        getCombSum(nums, target, ans, 0, 0, new ArrayList<>());
        return ans;   
    }

    public void getCombSum(int[] nums, int target,  List<List<Integer>> ans , int curSum, int start, List<Integer> cur){
        if(curSum == target) ans.add(new ArrayList<>(cur));
        if(curSum > target) return;

        for(int i = start; i < nums.length; i++){
            cur.add(nums[i]);
            getCombSum(nums, target, ans, curSum + nums[i], i, cur);
            cur.remove(cur.size() -1);
        }
    }
}
