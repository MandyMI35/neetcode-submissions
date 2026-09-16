class Solution {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int num : nums) sum+=num;
        if(sum%2!=0) return false;
        dp=new Boolean[nums.length][sum/2 +1];
        return dfs(nums,0,sum/2);
    }
    public boolean dfs(int[] nums, int i, int sum){
        if(i==nums.length) return sum==0;
        if(sum<0) return false;
        if(dp[i][sum]!=null) return dp[i][sum];
        dp[i][sum]=dfs(nums,i+1,sum) || dfs(nums,i+1,sum-nums[i]);
        return dp[i][sum];
    }
}
