class Solution {
    public int search(int[] nums, int target){
        int l=0, r=nums.length-1;
        while(l<r){
            int m =(l+r)/2;
            if(nums[m]>nums[r]) l=m+1;
            else r=m;
        }
        int pv = l;
        int res = bs(nums, target,0,pv-1);
        if(res!=-1) return res;
        return bs(nums,target,pv,nums.length-1);
    }
    public int bs(int[] nums, int t, int l, int r){
        while(l<=r){
            int m = (l+r)/2;
            if(nums[m]==t) return m;
            if(nums[m]>t) r=m-1;
            else l=m+1;
        }
        return -1;
    }
}
