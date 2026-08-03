class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        if(sum%2 !=0) return false;
        sum/=2;
        return dfs(nums,0,0,sum);
    }
    public boolean dfs(int[] nums, int i, int cs, int sum){
        if(cs==sum) return true;
        if(i==nums.length || sum<cs) return false;
        return dfs(nums,i+1,cs+nums[i],sum) || dfs(nums,i+1,cs,sum);
    }
}
