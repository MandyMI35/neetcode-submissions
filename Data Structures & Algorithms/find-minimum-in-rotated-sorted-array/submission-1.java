class Solution {
    public int findMin(int[] nums) {
        return find(nums, 0, nums.length-1);
    }
    public int find(int[] nums, int s, int e){
        if(s<e){
            int i=s+(e-s)/2;
            if(nums[i]>nums[i+1]){return nums[i+1];}
            if(i!=0 && nums[i]<nums[i-1]){return nums[i];}
            if(nums[i]<nums[s]){return find(nums,s,i-1);}
            else { return find(nums,i+1,e);}
        }
        return nums[0];
    }
}
