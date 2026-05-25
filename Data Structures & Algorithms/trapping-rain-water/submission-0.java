class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int lmax = height[0];
        int rmax = height[n - 1];

        int l = 1;
        int r = n - 2;
        int ans = 0;

        while (l <= r) {
            // System.out.println(lmax);
            // System.out.println(rmax);
            
            if (lmax > rmax) {
                if (rmax < height[r]) {
                    rmax = height[r];
                    r--;
                    continue;
                }

                ans += Math.min(lmax, rmax) - height[r];
                r--;
            } else {
                if (lmax < height[l]) {
                    lmax = height[l];
                    l++;
                    continue;
                }

                ans += Math.min(lmax, rmax) - height[l];
                l++;
            }
        }
        return ans;
    }
}