class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        getPerm(ans, nums, new ArrayList<>());
        return ans;
    }

    public void getPerm(List<List<Integer>> ans, int[] nums, List<Integer> cur) {
        if (cur.size() == nums.length)
            ans.add(new ArrayList<>(cur));
        
        else {
            for (int i = 0; i < nums.length; i++) {
                if (cur.contains(nums[i]))
                    continue;
                cur.add(nums[i]);
                getPerm(ans, nums, cur);
                cur.remove(cur.size() - 1);

            }
        }
    }
}