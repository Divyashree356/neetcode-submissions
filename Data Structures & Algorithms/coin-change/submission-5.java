class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int n = coins.length;

        int[][] dp = new int[n][amount+1];
        for(int[] d : dp) Arrays.fill(d, -1);
        int op = getCoins(coins, amount, coins.length -1, dp);

        return  op == (int)1e9 ? -1 : op;
    }
    public int getCoins(int[] coins, int amount, int idx, int[][] dp){
        if(idx == 0) {
            if(amount % coins[idx] == 0) return amount/coins[idx];
            else return (int)1e9;
        }

        if(dp[idx][amount] != -1) return dp[idx][amount];

        int notTake = getCoins(coins, amount, idx-1, dp);
        int take = Integer.MAX_VALUE;
        if(coins[idx] <= amount) {
            take = 1 + getCoins(coins, amount - coins[idx], idx, dp);
        }

        return dp[idx][amount]= Math.min(take, notTake);
    }

}
