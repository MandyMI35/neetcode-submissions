class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int right=nums.length-1,left=0;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if (nums[mid]<target){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return -1;
    }
}
