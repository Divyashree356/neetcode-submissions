class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int[] d : dp) Arrays.fill(d, -1);

        return countComb(amount, coins, 0, dp);
    }

    public int countComb(int amount, int[] coins, int idx, int[][] dp){
        if(amount == 0) return 1;
        if(idx == coins.length) return amount == 0 ? 1 : 0;
        
        // System.out.println(Arrays.toString(dp));
        if(dp[idx][amount] != -1) return dp[idx][amount];

        int notTake = countComb(amount, coins, idx+1, dp);
        int take = 0;
        if(coins[idx] <= amount){
            take = countComb(amount-coins[idx], coins, idx, dp);
        }
        return dp[idx][amount] = take + notTake;
    }
}