class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        Arrays.fill(dp,-1);
        return dfs(0, days, costs, dp);
    }
    public int dfs(int i, int[] days, int[] costs, int[] dp){
        if(i==days.length) return 0;
        if (dp[i]!=-1) return dp[i];
        dp[i]=Integer.MAX_VALUE;
        int idx =0, j=1;
        for(int d : new int[]{1,7,30}){
            while(j<days.length && days[j]<days[i]+d){
                j++;
            }
            dp[i]=Math.min(dp[i], costs[idx]+dfs(j, days, costs, dp));
            idx++;
        }
        return dp[i];
    }
}