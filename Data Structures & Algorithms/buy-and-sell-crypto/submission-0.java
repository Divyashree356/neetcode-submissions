class Solution {
    public int maxProfit(int[] prices) {

        if(prices.length == 1)return 0;
        int bp = prices[0];
        int sp = prices[1];
        int ans = 0;

        for (int i = 1; i < prices.length; i++) {
            if (bp > prices[i]) {
                bp = prices[i];
                sp = 0;
            } else {
                sp = Math.max(sp, prices[i]);
                ans = Math.max(ans, sp - bp);
            }
        }
            return ans;

    }
}