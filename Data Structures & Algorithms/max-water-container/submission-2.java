class Solution {
    public int maxArea(int[] heights) {
        
        int water = 0;

        int n = heights.length;
        
        int i = 0;
        int j = n-1;
        while(i < j){
        int left  = heights[i];
        int right = heights[j];

            if (left >= right){
                int cur = right * (j-i);
                water = Math.max(cur, water);
                j--;
            }
            else{
                int cur = left  * (j-i);
                water = Math.max(cur, water);
                i++;
            }
        }
    return water;
    }
}
