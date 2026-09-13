class Solution {
    int[] dp1;
    int[] dp2;
    public int rob(int[] nums) {
        if(1==nums.length) return nums[0];
        return Math.max(dfs(Arrays.copyOfRange(nums,0,nums.length-1)),dfs(Arrays.copyOfRange(nums,1,nums.length)));
    }
    public int dfs(int[] nums){
        if(0==nums.length) return 0;
        if(1==nums.length) return nums[0];
        int[] dp = new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
    }
}
