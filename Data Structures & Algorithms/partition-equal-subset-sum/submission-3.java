class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) sum+=num;
        if(sum%2!=0) return false;
        return summ(nums,0,sum/2,0);
    }
    public boolean summ(int[] nums, int i, int sum, int amt){
        if(sum==amt) return true;
        if(i==nums.length) return false;
        return summ(nums,i+1,sum,amt+nums[i]) || summ(nums,i+1,sum,amt);
    }
}
