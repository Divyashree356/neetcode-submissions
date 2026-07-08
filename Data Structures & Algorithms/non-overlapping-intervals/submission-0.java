class Solution {
    public int eraseOverlapIntervals(int[][] interval) {
        Arrays.sort(interval, (a, b) -> {   
            if(a[0] != b[0]) return Integer.compare(a[0], b[0]);
            else return Integer.compare(a[1], b[1]);
        });

        // System.out.println(Arrays.toString(interval));

        int n = interval.length;
        int[][] ans = new int[n][2];
        int idx = 0;
        int count =0;
        ans[idx] = new int[]{interval[0][0], interval[0][1]};

        for(int i =1; i < n; i++){
            if(ans[idx][1] > interval[i][0]){
                count++;
                if(ans[idx][1] > interval[i][1]) ans[idx][1] = interval[i][1];
            }
            
            else{
                idx++;
                ans[idx] = new int[]{interval[i][0], interval[i][1]};
            }
        }

        return count;
    }
}
