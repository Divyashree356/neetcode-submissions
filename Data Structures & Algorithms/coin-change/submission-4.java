class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int op = getCoins(coins, amount, coins.length -1);
        return  op == (int)1e9 ? -1 : op;
    }
    public int getCoins(int[] coins, int amount, int idx){
        if(idx == 0) {
            if(amount % coins[idx] == 0) return amount/coins[idx];
            else return (int)1e9;
        }

        int notTake = getCoins(coins, amount, idx-1);
        int take = Integer.MAX_VALUE;
        if(coins[idx] <= amount) {
            take = 1 + getCoins(coins, amount - coins[idx], idx);
        }

        return Math.min(take, notTake);
    }

}
