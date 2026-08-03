class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        if(sum%2 !=0) return false;
        sum/=2;
        Boolean[][] dp=new Boolean[nums.length][sum+1];
        return dfs(nums,0,0,sum, dp);
    }
    public boolean dfs(int[] nums, int i, int cs, int sum, Boolean[][] dp){
        if(cs==sum) return true;
        if(i==nums.length || sum<cs) return false;
        if(dp[i][cs]!=null) return dp[i][cs];
        dp[i][cs]=dfs(nums,i+1,cs+nums[i],sum, dp) || dfs(nums,i+1,cs,sum, dp);
        return dp[i][cs];
    }
}
