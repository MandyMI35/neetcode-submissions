class Solution {
    int[][] dp;
    int res=0;
    public int change(int amount, int[] coins) {
        dp = new int[amount+1][coins.length];
        for(int[] i : dp) Arrays.fill(i,-1);
        return dfs(amount,coins,0,0);
        // return res;
    }
    public int dfs(int amt, int[] coins, int i, int sum){
        if(i>=coins.length || sum>amt) return 0;
        if(dp[sum][i]!=-1) return dp[sum][i];
        if(amt==sum) {
            res++;
            return dp[sum][i]=1;
        }
        dp[sum][i]= dfs(amt,coins,i,sum+coins[i]) + dfs(amt,coins,i+1,sum);
        return dp[sum][i];
    }
}
