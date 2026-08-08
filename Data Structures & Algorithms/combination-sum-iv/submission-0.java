class Solution {
    public int combinationSum4(int[] nums, int target) {
        Integer[] dp = new Integer[target+1];
        return dfs(nums, target, dp);
    }
    public int dfs(int[] nums, int rem, Integer[] dp){
        if(rem==0) return 1;
        if(rem<0) return 0;
        if(dp[rem]!=null) return dp[rem];
        int ct=0;
        for(int num : nums){
            ct+=dfs(nums, rem-num, dp);
        }
        return dp[rem]=ct;
    }
}