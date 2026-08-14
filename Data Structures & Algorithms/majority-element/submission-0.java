class Solution {
    public int majorityElement(int[] nums) {
        int mj=nums[0];
        int cnt=1;
        for(int i=1;i<nums.length;i++){
            if(mj==nums[i]) cnt++;
            else if(mj!=nums[i] && cnt!=1) cnt--;
            else if(mj!=nums[i] && cnt==1) mj=nums[i];
        }
        return mj;
    }
}