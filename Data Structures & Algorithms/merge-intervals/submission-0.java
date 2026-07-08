class Solution {
    public int[][] merge(int[][] interval) {
        Arrays.sort(interval, (a, b) -> Integer.compare(a[0], b[0]));
        
        int n = interval.length;
        int[][] ans = new int[n][2];
        int idx = 0;
        ans[idx] = new int[]{interval[0][0], interval[0][1]};

        for(int i =1; i < n; i++){
            if(ans[idx][1] >= interval[i][0]){
                ans[idx][0] = Math.min(ans[idx][0], interval[i][0]);
                ans[idx][1] = Math.max(ans[idx][1], interval[i][1]);
            }
            else{
                idx++;
                ans[idx] = new int[]{interval[i][0], interval[i][1]};
            }
        }

        return Arrays.copyOf(ans, idx + 1);

    }
}
