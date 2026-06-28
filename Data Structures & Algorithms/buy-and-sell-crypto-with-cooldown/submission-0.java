class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for(int[] d : dp) Arrays.fill(d, -1);
        return maxP(prices, 1, 0, dp);        
    }

    public int maxP(int[] prices, int buy, int days, int[][] dp){
        if(prices.length <= days) return 0;
        
        if(dp[days][buy] != -1) return dp[days][buy];

        int profit = 0;
        if(buy == 1){
            int take = -prices[days] + maxP(prices, 0, days+1, dp);
            int notTake = maxP(prices, 1, days+1, dp);
            profit = Math.max(take, notTake);
        }   
        else{
            int take = prices[days] + maxP(prices, 1, days+2, dp);
            int notTake = maxP(prices, 0, days+1, dp);
            profit = Math.max(take, notTake);
        }

        return dp[days][buy]=profit;
    }
}
