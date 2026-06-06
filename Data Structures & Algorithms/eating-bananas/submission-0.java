class Solution {
    public int minEatingSpeed(int[] piles, int h) {
       int n = piles.length;

       int low = 1;
       int high = 0;

       for(int i: piles){
        high = Math.max(high, i);
       }
        int ans = high;

       while(low <= high){
        
        int mid = low + (high-low)/2;
        long curHours = minHoursAtSpeedK(piles, mid);
        // System.out.println(mid);

        if (curHours <= h) {
            ans = mid;
            high = mid-1;
        }

        else low = mid+1;
       }

    return ans;
    }

    public long minHoursAtSpeedK(int[] p, int k){
        long h = 0;

        for(int pile : p){
            h += (int)Math.ceil((double)pile/k);
        }
        return h;
    }

}