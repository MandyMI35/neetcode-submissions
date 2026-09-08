class Solution {
    int[] dp;
    public int climbStairs(int n) {
        dp=new int[n];
        Arrays.fill(dp,-1);
        return dfs(n,0);
    }
    public int dfs(int n, int sum){
        if(n==sum){
            return 1;
        }
        if(n<sum) return 0;
        if(dp[sum]!=-1) return dp[sum];
        dp[sum]=dfs(n,sum+1)+dfs(n,sum+2);
        return dp[sum];
    }
}
